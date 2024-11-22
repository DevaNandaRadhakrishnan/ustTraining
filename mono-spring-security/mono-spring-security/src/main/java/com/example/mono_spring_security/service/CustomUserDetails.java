package com.example.mono_spring_security.service;

import com.example.mono_spring_security.entity.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetails implements UserDetails {

    private String name;
    private String password;
    private List<SimpleGrantedAuthority> allRoles;

    public CustomUserDetails(String name, String password, List<Roles> allRoles) {
        super();
        this.name = name;
        this.password = password;
        this.allRoles = allRoles.stream().map((role)-> new SimpleGrantedAuthority(role.getRoleName())).toList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
