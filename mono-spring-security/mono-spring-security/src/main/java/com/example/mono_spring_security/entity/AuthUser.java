package com.example.mono_spring_security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="user_details")
public class AuthUser {
    @Id
    @Column(name = "auth_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authId;

    @Column(name = "auth_username")
    private String authUsername;

    @Column(name = "auth_password")
    private String authPassword;

    @ManyToMany
    @JoinTable(name = "credential_role", joinColumns = @JoinColumn(name="auth_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Roles> allRoles;
}
