package com.emindsblogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emindsblogapplication.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT u.id FROM Post u WHERE u.title = ?1")
    Long getPostByTitle(String title);
	
	

}
