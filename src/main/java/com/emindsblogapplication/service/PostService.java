package com.emindsblogapplication.service;

import java.util.List;

import com.emindsblogapplication.dto.PostDto;
import com.emindsblogapplication.exception.PostNotFoundException;

public interface PostService {

	PostDto createPost(PostDto postDto);

	List<PostDto> getAllPosts();

	PostDto getPostById(Long id) throws PostNotFoundException;



	

}
