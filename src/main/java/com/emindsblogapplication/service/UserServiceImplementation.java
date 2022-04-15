package com.emindsblogapplication.service;

import com.emindsblogapplication.dto.RegisterDto;
import com.emindsblogapplication.entity.Roles;
import com.emindsblogapplication.entity.User;
import com.emindsblogapplication.exception.DataAlreadyExistsException;
import com.emindsblogapplication.repository.RoleRepository;
import com.emindsblogapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImplementation implements  UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(RegisterDto registerDto) throws DataAlreadyExistsException {

        // add check for username exists in a DB
        //Optional<user.> cid_userName = userRepository.findByUserName(registerDto.getUsername());
       // Optional<User> cid_email  = userRepository.findByEmail(registerDto.getEmail());

        if(userRepository.existsByUsername(registerDto.getUsername())){

            throw new DataAlreadyExistsException(" user name already exists try another user name");

        }

        //checks for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){

            throw new DataAlreadyExistsException("email is already exists choose another");

        }
        //create a user object

        User  user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setName(registerDto.getName());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Roles roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);


    }
}
