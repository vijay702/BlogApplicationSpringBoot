package com.emindsblogapplication.controller;

import com.emindsblogapplication.dto.CommentDto;
import com.emindsblogapplication.entity.ErrorMessage;
import com.emindsblogapplication.exception.NotFoundException;
import com.emindsblogapplication.exception.PostNotFoundException;
import com.emindsblogapplication.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

 @Autowired
private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable (name = "postId")
                                          Long postId, @RequestBody CommentDto commentDto) throws PostNotFoundException {


        return new ResponseEntity(commentService.createComment(postId , commentDto), HttpStatus.CREATED);


    }
    @GetMapping("/post/{postId}/comments")
    public List<CommentDto> getCommentByPostId(@PathVariable (name = "postId" )Long postId){

      return  commentService.getCommentByPostId(postId);

    }

    @GetMapping("/post/{postId}/comments/{commentId}")
    public ResponseEntity <CommentDto> getCommentById(@PathVariable (name ="postId") Long postId ,
                                     @PathVariable (name = "commentId") Long commentId) throws PostNotFoundException {


            CommentDto commentDto = commentService.getCommentById(postId,commentId);

            return  new ResponseEntity<>(commentDto,HttpStatus.OK);
    }


    @PutMapping("/post/{postId}/comments/{commentId}")
    public ResponseEntity <CommentDto> UpdateComment(@PathVariable (name ="postId") Long postId ,
                                                      @PathVariable (name = "commentId") Long commentId
                                                      , @RequestBody CommentDto commentDto) throws PostNotFoundException, NotFoundException {


     return new ResponseEntity<>(commentService.updateComment(postId,commentId,commentDto),HttpStatus.OK);


    }

    @DeleteMapping("/post/{postId}/comments/{commentId}")
    public  ResponseEntity<String> DeleteCommentById(@PathVariable (name ="postId") Long postId ,
                                                      @PathVariable (name = "commentId") Long commentId) throws PostNotFoundException, NotFoundException {

       commentService.DeleteCommentById(postId ,commentId);
       return new ResponseEntity<>("Comment Deleted SucessFlly " , HttpStatus.OK);



    }


}
