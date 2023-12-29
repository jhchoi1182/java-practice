package com.in28minutes.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;

// JpaRepository<Entity, id필드 타입>
public interface UserRepository extends JpaRepository<User, Integer> {

}