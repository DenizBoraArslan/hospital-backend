package com.db.models;

import com.db.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String phoneNumber;

}
