package com.example.furama_resort_management.model.employee;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String username;
    private String password;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    public User() {
    }

    public User(String username, String password, boolean isDeleted) {
        this.username = username;
        this.password = password;
        this.isDeleted = isDeleted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
