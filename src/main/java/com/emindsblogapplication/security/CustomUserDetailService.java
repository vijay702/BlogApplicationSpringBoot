package com.emindsblogapplication.security;

import com.emindsblogapplication.entity.Roles;
import com.emindsblogapplication.entity.User;
import com.emindsblogapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameorEmail) throws UsernameNotFoundException {

      User user = userRepository.findByUserNameOrEmail(usernameorEmail , usernameorEmail)
                .orElseThrow(()->new UsernameNotFoundException("user not found with username or email"));

      return new org.springframework.security.core.userdetails.User
              (user.getEmail(),user.getPassword(), mapRolesAuthorities(user.getRoles()));

    }

    private Collection< ? extends GrantedAuthority> mapRolesAuthorities(Set<Roles> role){

       return  role.stream().map(roles -> new SimpleGrantedAuthority(roles.getName())).collect(Collectors.toList());
    }
}
