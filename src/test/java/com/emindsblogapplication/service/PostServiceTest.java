package com.emindsblogapplication.service;

import com.emindsblogapplication.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {
    @Autowired
    private PostService postService;

    @BeforeEach
    void setUp() {
    }


    public void whenValidPostId_thenPostShouldFound(){



    }
}