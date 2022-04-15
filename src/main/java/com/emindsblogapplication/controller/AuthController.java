package com.emindsblogapplication.controller;

import com.emindsblogapplication.dto.LogInDto;
import com.emindsblogapplication.dto.RegisterDto;
import com.emindsblogapplication.entity.Roles;
import com.emindsblogapplication.entity.User;
import com.emindsblogapplication.exception.DataAlreadyExistsException;
import com.emindsblogapplication.repository.RoleRepository;
import com.emindsblogapplication.repository.UserRepository;
import com.emindsblogapplication.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Api(value = " Auth Controller has signin and Signup Rest Api")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @ApiOperation("Rest APi For Log in")
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser( @RequestBody LogInDto logInDto){

      Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (logInDto.getUsernameOrEmail(), logInDto.getPassword()));


        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User Signed-in SucessFully !!.....", HttpStatus.OK);
    }
   @ApiOperation(value = "Rest Api For Register User")
    @PostMapping("/signup")
    public String  registerUser( @RequestBody  RegisterDto registerDto) throws DataAlreadyExistsException {

        userService.registerUser(registerDto);
        return  "user registred sucessfully";

    }

}
