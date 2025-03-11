package com.example.ProjetodeExtencao.entities.user;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_users", nullable = false, unique = true)
    private UUID id;

    @Column(name = "name_users", nullable = false, unique = true)
    private String name;

    @Column(name = "email_users", nullable = false, unique = true)
    private String email;

    @Column(name = "password_users", nullable = false)
    private String password;

    @Column(name = "role_user", nullable = false)
    private UserRole role;



    public User(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN){
            return List.of(new SimpleGrantedAuthority(UserRole.ADMIN.getRole()),
                    new SimpleGrantedAuthority(UserRole.CONTADORES.getRole()),
                    new SimpleGrantedAuthority(UserRole.AUDITORES.getRole()));
        } else {
            return List.of(new SimpleGrantedAuthority(this.role.getRole()));
        }
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
