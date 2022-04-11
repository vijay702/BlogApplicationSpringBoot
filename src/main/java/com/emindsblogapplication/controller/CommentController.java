package com.emindsblogapplication.controller;

import com.emindsblogapplication.dto.CommentDto;
import com.emindsblogapplication.exception.PostNotFoundException;
import com.emindsblogapplication.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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




}
