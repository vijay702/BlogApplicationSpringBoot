package com.emindsblogapplication.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.emindsblogapplication.exception.PostNotFoundException;
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
		
		//convert dto to entity
		Post post = mapToEntity(postDto);
		
		Post newpost = postRepository.save(post);
		
		//convert entity to dto 
		
		PostDto postResponse = mapToDto(newpost);
	
		return postResponse;
	}

	@Override
	public List<PostDto> getAllPosts() {

		
		List<Post> posts = postRepository.findAll();
		return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
	
	}
	
	@Override
	public PostDto getPostById(Long id) throws PostNotFoundException {
		
		Optional<Post> post = postRepository.findById(id);
		
		if(!post.isPresent()) {

			throw  new PostNotFoundException("enter a correct id , there is no post for entered id");
			
					}
	
		Post newPost = post.get();
		
		return mapToDto(newPost);
	}

	//converting dto to entity
   private Post mapToEntity(PostDto postDto) {
	
	 Post post = new Post();
	 post.setTitle(postDto.getTitle());
	 post.setDescrption(postDto.getDescrption());
	 post.setContent(postDto.getContent());
	return post;
   }
	//converting entity to dto
	
	private PostDto mapToDto(Post post) {
		
		
		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setDescrption(post.getDescrption());
		postDto.setContent(post.getContent());
		return postDto;
		
		
		
	}

	

	
	
}
	


