package com.emindsblogapplication.service;

import java.util.List;

import com.emindsblogapplication.dto.PostDto;
import com.emindsblogapplication.entity.PostResponse;
import com.emindsblogapplication.exception.DataAlreadyExistsException;
import com.emindsblogapplication.exception.PostNotFoundException;

public interface PostService {


	public  void deletePostById(Long id) throws PostNotFoundException;

	PostDto createPost(PostDto postDto) throws DataAlreadyExistsException;

	PostResponse getAllPosts(Integer pageNO , Integer pageSize);

	PostDto getPostById(Long id) throws PostNotFoundException;


	PostDto updatePost(PostDto postDto, Long id) ;


}
