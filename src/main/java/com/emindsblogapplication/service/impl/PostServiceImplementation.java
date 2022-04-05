package com.emindsblogapplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emindsblogapplication.dto.PostDto;
import com.emindsblogapplication.entity.Post;
import com.emindsblogapplication.repository.PostRepository;
import com.emindsblogapplication.service.PostService;

@Service
public class PostServiceImplementation implements PostService {
	

	@Autowired
	private PostRepository postRepository;
	


	@Override
	public PostDto createPost(PostDto postDto) {
		//convert DTO to entity 
		
		Post post = new Post();
		
		post.setTitle(postDto.getTitle());
		post.setDescrption(postDto.getDescrption());
		post.setContent(postDto.getContent());
		
		
		Post  newPost = postRepository.save(post);
		
		//convert entity to dto
		
		PostDto postResponse = new PostDto();
		
		postResponse.setId(newPost.getId());
		postResponse.setTitle(newPost.getTitle());
		postResponse.setDescrption(newPost.getDescrption());
		postResponse.setContent(newPost.getContent());
		return postResponse;
	}


	
	

}
