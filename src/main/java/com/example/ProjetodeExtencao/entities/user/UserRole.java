package com.example.ProjetodeExtencao.entities.user;

public enum UserRole {

    ADMIN("ROLE_ADMIN"),

    CONTADORES("ROLE_CONTADOR"),

    AUDITORES("ROLE_AUDITOR");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return  role;
    }
}
