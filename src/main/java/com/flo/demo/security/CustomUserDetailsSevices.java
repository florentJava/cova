package com.flo.demo.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.flo.demo.entity.UserEntity;
import com.flo.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsSevices  implements UserDetailsService{

    private final UserService userService;

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userService.getUserByEmail(username).orElseThrow();

        return UserPrincipal.builder()
                .email(user.getEmail())
                .userId(user.getId())
                .password(user.getPassword())
                .authorities( List.of( new SimpleGrantedAuthority(user.getRole().toString())))
                .build();   
    }
    
}
