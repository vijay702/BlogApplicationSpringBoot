package com.emindsblogapplication.service;

import com.emindsblogapplication.dto.CommentDto;
import com.emindsblogapplication.exception.PostNotFoundException;

import java.util.List;

public interface CommentService {
    CommentDto createComment(Long postId, CommentDto commentDto) throws PostNotFoundException;

    List<CommentDto> getCommentByPostId(Long postId);

    CommentDto getCommentById(Long postId, Long commentId) throws PostNotFoundException;
}
