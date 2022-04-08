package com.emindsblogapplication.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.emindsblogapplication.entity.PostResponse;
import com.emindsblogapplication.exception.DataAlreadyExistsException;
import com.emindsblogapplication.exception.PostNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emindsblogapplication.dto.PostDto;
import com.emindsblogapplication.entity.Post;
import com.emindsblogapplication.repository.PostRepository;
import com.emindsblogapplication.service.PostService;

@Service
public class PostServiceImplementation implements PostService {
	

	@Autowired
	private PostRepository postRepository;

	private static  final Logger LOGGER = LoggerFactory.getLogger(PostServiceImplementation.class);

	@Override
	public void deletePostById(Long id) throws PostNotFoundException {

		Optional<Post> post = postRepository.findById(id);
		if(!post.isPresent()) {

			throw  new PostNotFoundException("enter a correct id , there is no post for entered id");
		}
		Post newPost = post.get();
		postRepository.delete(newPost);
	}

	@Override
	public PostDto createPost(PostDto postDto) throws DataAlreadyExistsException {
		
		//convert dto to entity
		Post post = mapToEntity(postDto);

		Long CID = postRepository.getPostByTitle(post.getTitle());
		if(null !=CID){
			LOGGER.info("Post already exist "  + post.getTitle());
			post.setApiStatus("1");
			post.setApiMessage("post already exist , chhose another title");
			//post.setId(CID);

			throw new DataAlreadyExistsException("title already exists please select a another title");
		}
		//convert entity to dto
			Post newpost = postRepository.save(post);
			PostDto postResponse = mapToDto(newpost);
			return postResponse;

	}

	@Override
	public PostResponse getAllPosts(Integer pageNO , Integer pageSize) {
       //create a pagebable instance

		Pageable pageable = PageRequest.of(pageNO,pageSize);

		Page<Post> posts = postRepository.findAll(pageable);

		//get content from page objcet

		List<Post> listOfPosts =posts.getContent();

		List<PostDto> content = listOfPosts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

		PostResponse postResponse = new PostResponse();
		postResponse.setContent(content);
		postResponse.setPageNo(posts.getNumber());
		postResponse.setPageSize(posts.getSize());
		postResponse.setTotalElements(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLast(posts.isLast());

		return  postResponse;

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

	@Override
	public PostDto updatePost(PostDto postDto, Long id)  {
		// get post by id
		Post post = postRepository.findById(id).get();


		

		post.setTitle(postDto.getTitle());
		post.setDescrption(postDto.getDescrption());
		post.setContent(postDto.getDescrption());
		Post updatePost = postRepository.save(post);

		return mapToDto(updatePost);
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
	


