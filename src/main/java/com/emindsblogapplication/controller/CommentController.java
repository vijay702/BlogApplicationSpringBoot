package com.emindsblogapplication.controller;

import com.emindsblogapplication.dto.CommentDto;
import com.emindsblogapplication.entity.ErrorMessage;
import com.emindsblogapplication.exception.NotFoundException;
import com.emindsblogapplication.exception.PostNotFoundException;
import com.emindsblogapplication.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "Crud Rest Apis For Comment")
@RestController
@RequestMapping("/api/")
public class CommentController {

 @Autowired
private CommentService commentService;
    @ApiOperation(value = "Rest Api For Create Comment")
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable (name = "postId")
                                          Long postId, @RequestBody CommentDto commentDto) throws PostNotFoundException {


        return new ResponseEntity(commentService.createComment(postId , commentDto), HttpStatus.CREATED);


    }
    @ApiOperation(value = "Rest Api For Get All Comment")
    @GetMapping("/post/{postId}/comments")
    public List<CommentDto> getCommentByPostId(@PathVariable (name = "postId" )Long postId){

      return  commentService.getCommentByPostId(postId);

    }
    @ApiOperation(value = "Rest Api For Get Comment By Id ")
    @GetMapping("/post/{postId}/comments/{commentId}")
    public ResponseEntity <CommentDto> getCommentById(@PathVariable (name ="postId") Long postId ,
                                     @PathVariable (name = "commentId") Long commentId) throws PostNotFoundException {


            CommentDto commentDto = commentService.getCommentById(postId,commentId);

            return  new ResponseEntity<>(commentDto,HttpStatus.OK);
    }



    @ApiOperation(value = "Rest Api For Update Comment By Id ")
      @PutMapping("/post/{postId}/comments/{commentId}")
    public ResponseEntity <CommentDto> UpdateComment(@PathVariable (name ="postId") Long postId ,
                                                      @PathVariable (name = "commentId") Long commentId
                                                      , @RequestBody CommentDto commentDto) throws PostNotFoundException, NotFoundException {


     return new ResponseEntity<>(commentService.updateComment(postId,commentId,commentDto),HttpStatus.OK);


    }
    @ApiOperation(value = "Rest Api For Delete Comment By Id ")
    @DeleteMapping("/post/{postId}/comments/{commentId}")
    public  ResponseEntity<String> DeleteCommentById(@PathVariable (name ="postId") Long postId ,
                                                      @PathVariable (name = "commentId") Long commentId) throws PostNotFoundException, NotFoundException {

       commentService.DeleteCommentById(postId ,commentId);
       return new ResponseEntity<>("Comment Deleted SucessFlly " , HttpStatus.OK);



    }


}
