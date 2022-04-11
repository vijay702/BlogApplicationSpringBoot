package com.emindsblogapplication.repository;

import com.emindsblogapplication.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentREpository extends JpaRepository<Comment , Long> {

    List<Comment> findByPostId(Long postId);


    @Query("SELECT u.commentId FROM Comment u WHERE u.email = ?1")
    Long getCommentByEmail(String  email);



}
