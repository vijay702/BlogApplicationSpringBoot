package com.emindsblogapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    //inject required dependency
    @Autowired
    private  JwtTokenProvider  jwtTokenProvider;

    @Autowired
    private  CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // get jwt (token) from http request


        //validate token


        //get username from token

        //load user associated with token

        // set spring security




    }

    //<bearer acees token>
    private String getJwtFromToken(HttpServletRequest request){

    }
}
