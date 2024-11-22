package com.example.mono_spring_security.repository;

import com.example.mono_spring_security.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findByAuthUsername(String name);
}
