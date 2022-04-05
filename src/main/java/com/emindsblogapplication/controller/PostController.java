package com.emindsblogapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emindsblogapplication.dto.PostDto;
import com.emindsblogapplication.service.PostService;

@RestController
@RequestMapping("api/post")
public class PostController {
	
	@Autowired
	private PostService postService ;
	
	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
		
		
		
		return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
	}

}
