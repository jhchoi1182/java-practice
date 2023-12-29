package com.in28minutes.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.restfulwebservices.user.Post;

// JpaRepository<Entity, id필드 타입>
public interface PostRepository extends JpaRepository<Post, Integer> {

}