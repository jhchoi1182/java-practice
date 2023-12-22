package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	// ResponseEntityExceptionHandler의 handleException 메소드를 커스텀
	@ExceptionHandler(Exception.class)	// 모든 예외 지정 (어떤 예외를 처리할 건지)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
	
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);	// 상태 코드 지정
	}
	
	@ExceptionHandler(UserNotFoundException.class)	// 에러처리를 UserNotFoundException클래스가 담당할 경우
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
	
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	// ResponseEntityExceptionHandler에 있는 handleMethodArgumentNotValid를 오버라이드해서 커스텀
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		// 1. 기본 메세지
		String defaultMessage = ex.getMessage();
		// 2. 내가 설정한 메세지만 보여주고 싶을 때
		String customMessage = ex.getFieldError().getDefaultMessage();
		// 3. 2번에서 에러가 여러 개일 수 있는 경우
		String customMessages = ex.getFieldErrors().stream()
							        .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
							        .collect(Collectors.joining(", "));
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
