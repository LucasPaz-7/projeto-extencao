package com.example.ProjetodeExtencao.repositories;

import com.example.ProjetodeExtencao.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByName(String name);
    UserDetails findByEmail(String email);
}