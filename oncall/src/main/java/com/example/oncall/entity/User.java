package com.example.oncall.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_oncall_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "p_name", length = 100)
    private String p_name;

    @Column(name = "p_phone", length = 20)
    private String p_phone;

    @Column(name = "p_email", length = 100)
    private String p_email;

    @Column(name = "p_role", length = 20)
    private String p_role;
}
