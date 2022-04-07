package com.emindsblogapplication.service;

import java.util.List;

import com.emindsblogapplication.dto.PostDto;
import com.emindsblogapplication.exception.PostNotFoundException;

public interface PostService {


	public  void deletePostById(Long id) throws PostNotFoundException;

	PostDto createPost(PostDto postDto);

	List<PostDto> getAllPosts(int pageNO , int pageSize);

	PostDto getPostById(Long id) throws PostNotFoundException;


	PostDto updatePost(PostDto postDto, Long id) ;


}
