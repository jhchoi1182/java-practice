package com.in28minutes.rest.webservices.restfulwebservices.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
// import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; 도 가능

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	private UserRepository repository;

	public UserJpaResource(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	// EntityModel 설정
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		// findById는 Optional<T>를 반환
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		// EntityModel 클래스 인스턴스 생성
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		// WebMvcLinkBuilder - 스프링 MVC 컨트롤러를 가리키는 링크 인스턴스 구축을 용이하게 해주는 빌더
		// EntityModel에 WebMvcLinkBuilder를 이용해 retrieveAllUsers 링크 추가
		WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		// 링크 이름 지정
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		User savedUser = repository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()	// 현재 요청에 해당하는 URL를 반환
						.path("/{id}")	// URL에 추가
						.buildAndExpand(savedUser.getId())	// id 부분은 바꿔줌
						.toUri();   // 값을 URI로 변경
		
		// location대신 null을 입력하면 응답 헤더에 아무것도 안 실림
		// location을 지정해줄 경우 생성된 리소스의 uri값을 응답값 헤더에 실어서 반환할 수 있음
		// ex) http://localhost:8080/users/4
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
}