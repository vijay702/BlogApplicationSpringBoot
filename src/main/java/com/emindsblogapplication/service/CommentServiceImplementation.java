package com.emindsblogapplication.service;

import com.emindsblogapplication.dto.CommentDto;
import com.emindsblogapplication.entity.Comment;
import com.emindsblogapplication.entity.ErrorMessage;
import com.emindsblogapplication.entity.Post;
import com.emindsblogapplication.exception.DataAlreadyExistsException;
import com.emindsblogapplication.exception.NotFoundException;
import com.emindsblogapplication.exception.PostNotFoundException;
import com.emindsblogapplication.repository.CommentREpository;
import com.emindsblogapplication.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImplementation implements  CommentService {
    @Autowired
    private CommentREpository commentREpository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper mapper;

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

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto) throws PostNotFoundException, NotFoundException {
        //retrive post by postID

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("enter a correct post ID "));

        //retrive comment by commentBy id
        Comment comment = commentREpository.findById(commentId).orElseThrow
                (() -> new PostNotFoundException("enter a correct id"));

        if(!comment.getPost().getId().equals(post.getId())){

            throw new NotFoundException(HttpStatus.BAD_REQUEST , " Comment does Not Belongs to the POst");
        }
        //updating
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        Comment  updatedComment =commentREpository.save(comment);

        return maptoDto(updatedComment);
    }

    @Override
    public void DeleteCommentById(Long postId, Long commentId) throws PostNotFoundException, NotFoundException {
        //retrive post by postID

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("enter a corect id"));

        //retrive comment by commentID\
        Comment comment = commentREpository.findById(commentId)
                .orElseThrow(() -> new PostNotFoundException("enter a correct comment id"));

        if(!comment.getPost().getId().equals(post.getId())){

            throw new NotFoundException(HttpStatus.BAD_REQUEST, "comment does not belongs to Post");
        }

        commentREpository.delete(comment);


    }

    // converting dto to entity
    private Comment mapToEntity(CommentDto commentDto){

        Comment comment = mapper.map(commentDto,Comment.class);

       /* Comment comment = new Comment();
        comment.setCommentId(commentDto.getCommentId());
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());*/

        return  comment;
    }

    //converting entity to dto
    private CommentDto maptoDto(Comment comment){

      CommentDto commentDto = mapper.map(comment,CommentDto.class);

     /* CommentDto commentDto = new CommentDto();
      commentDto.setCommentId(comment.getCommentId());
      commentDto.setEmail(comment.getEmail());
      commentDto.setBody(comment.getBody());
      commentDto.setName(comment.getName()); */

      return commentDto;
    }
}
