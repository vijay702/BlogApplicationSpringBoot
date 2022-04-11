package com.emindsblogapplication.service;

import com.emindsblogapplication.dto.CommentDto;
import com.emindsblogapplication.exception.PostNotFoundException;

public interface CommentService {
    CommentDto createComment(Long postId, CommentDto commentDto) throws PostNotFoundException;
}
