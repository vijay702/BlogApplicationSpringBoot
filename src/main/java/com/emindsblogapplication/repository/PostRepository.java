package com.emindsblogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emindsblogapplication.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	

}
