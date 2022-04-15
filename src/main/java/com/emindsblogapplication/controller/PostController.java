package com.emindsblogapplication.controller;

import java.util.List;

import com.emindsblogapplication.entity.PostResponse;
import com.emindsblogapplication.exception.DataAlreadyExistsException;
import com.emindsblogapplication.exception.PostNotFoundException;
import com.emindsblogapplication.utils.AppConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.emindsblogapplication.dto.PostDto;
import com.emindsblogapplication.service.PostService;
@Api(value = "CRUD Apis For Post ")
@RestController
@RequestMapping("api/post")
public class PostController {
	
	@Autowired
	private PostService postService ;
	@ApiOperation(value = "Rest Api For create Post  ")
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) throws DataAlreadyExistsException {
		
		
		
		return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Rest Api For Get ALl Post   ")
	@GetMapping
	public PostResponse getAllPosts(
			@RequestParam(value="pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
			@RequestParam(value = "pageSize" , defaultValue = AppConstants.DEFAULT_PAGE_SIZE ,required = false) int pageSize,
			@RequestParam (value ="sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY , required = false)String sortBy,
			@RequestParam (value = "sortDir" , defaultValue = AppConstants.DEFAULT_SORT_DIRECTION ,required = false) String sortDir
	){
		
		return postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
	}
	@ApiOperation(value = "Rest Api For Get Post By Id ")
	@GetMapping("/{id}")
	public PostDto getPostById(@PathVariable ("id") Long id) throws PostNotFoundException {
		
		return postService.getPostById( id);
	}
	@ApiOperation(value = "Rest Api For Update Post By Id ")
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable (name ="id") Long id )  {

		PostDto postResponse = postService.updatePost(postDto,id);

		return new ResponseEntity<>(postResponse,HttpStatus.OK);

	}
	@ApiOperation(value = "Rest Api For Delete Post By Id ")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public String deletePostById(@PathVariable("id") Long id) throws PostNotFoundException {


		postService.deletePostById(id);
		return "post deleted sucessfully";

	}





}
