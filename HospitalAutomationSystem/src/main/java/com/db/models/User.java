package com.db.models;


import com.db.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User extends BaseEntity {


    private String username;

    private String password;

    private Role role;


}
