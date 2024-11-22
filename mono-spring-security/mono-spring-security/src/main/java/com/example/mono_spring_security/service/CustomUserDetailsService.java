package com.example.mono_spring_security.service;

import com.example.mono_spring_security.entity.AuthUser;
import com.example.mono_spring_security.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AuthUserRepository authUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> authUser = Optional.ofNullable(authUserRepository.findByAuthUsername(username));
        return authUser
                .map((userInfo)->new CustomUserDetails(userInfo.getAuthUsername(), userInfo.getAuthPassword(), userInfo.getAllRoles()))
                .orElseThrow(()-> new UsernameNotFoundException(username + " not found"));
    }

}
