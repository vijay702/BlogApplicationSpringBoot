package com.emindsblogapplication.service;

import com.emindsblogapplication.dto.CommentDto;
import com.emindsblogapplication.entity.Comment;
import com.emindsblogapplication.entity.Post;
import com.emindsblogapplication.exception.DataAlreadyExistsException;
import com.emindsblogapplication.exception.PostNotFoundException;
import com.emindsblogapplication.repository.CommentREpository;
import com.emindsblogapplication.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImplementation implements  CommentService {
    @Autowired
    private CommentREpository commentREpository;

    @Autowired
    private PostRepository postRepository;

    private  static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImplementation.class);

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) throws PostNotFoundException {
        //dto to entity
        Comment comment = mapToEntity(commentDto);

       //retrive post entity by id
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("enter a correct id"));

        //set post too comment entity
        comment.setPost(post);

        //save comment entity to the database
        Comment newComment = commentREpository.save(comment);
        //return entity to dto to user
       return maptoDto(newComment);
    }

    @Override
    public List<CommentDto> getCommentByPostId(Long postId) {
       //retrive comment by postId
       List<Comment> comments = commentREpository.findByPostId(postId);


       // convert list of comment entites to dto
        return comments.stream().map(comment -> maptoDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) throws PostNotFoundException {

        //retrive post by post Id
        //retrive post entity by id
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("enter a correct id"));

        //retrive Comment By Id
        Comment comment = commentREpository.findById(commentId).orElseThrow(() ->
                new PostNotFoundException("Enter a Correct Comment id "));

        return maptoDto(comment);
    }

    // converting dto to entity
    private Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setCommentId(commentDto.getCommentId());
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());

        return  comment;
    }

    //converting entity to dto
    private CommentDto maptoDto(Comment comment){
      CommentDto commentDto = new CommentDto();

      commentDto.setCommentId(comment.getCommentId());
      commentDto.setEmail(comment.getEmail());
      commentDto.setBody(comment.getBody());
      commentDto.setName(comment.getName());

      return commentDto;
    }
}
