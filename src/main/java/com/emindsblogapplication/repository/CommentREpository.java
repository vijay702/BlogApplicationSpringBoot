package com.emindsblogapplication.repository;

import com.emindsblogapplication.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentREpository extends JpaRepository<Comment , Long> {





}
