package com.emindsblogapplication.controller;

import java.util.List;

import com.emindsblogapplication.entity.PostResponse;
import com.emindsblogapplication.exception.DataAlreadyExistsException;
import com.emindsblogapplication.exception.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emindsblogapplication.dto.PostDto;
import com.emindsblogapplication.service.PostService;

@RestController
@RequestMapping("api/post")
public class PostController {
	
	@Autowired
	private PostService postService ;
	
	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) throws DataAlreadyExistsException {
		
		
		
		return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public PostResponse getAllPosts(
			@RequestParam(value="pageNo", defaultValue = "0",required = false) Integer pageNo,
			@RequestParam(value = "pageSize" , defaultValue = "10" ,required = false) Integer pageSize){
		
		return postService.getAllPosts(pageNo,pageSize);
	}

	@GetMapping("/{id}")
	public PostDto getPostById(@PathVariable ("id") Long id) throws PostNotFoundException {
		
		return postService.getPostById( id);
	}
    @PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable (name ="id") Long id )  {

		PostDto postResponse = postService.updatePost(postDto,id);

		return new ResponseEntity<>(postResponse,HttpStatus.OK);

	}
	@DeleteMapping("{id}")
	public String deletePostById(@PathVariable("id") Long id) throws PostNotFoundException {


		postService.deletePostById(id);
		return "post deleted sucessfully";

	}





}
