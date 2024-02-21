package com.estoque.vendas.enums;

public enum UserRole {

    ADMIN("admin"),
    VENDEDOR("vendedor");

    private String role;

    UserRole(String role){
        this.role = role;
    }

}
