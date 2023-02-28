package com.codegym.user.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class AppRole {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "appRole")
    private Set<UserRole> userRoleSet;

    public AppRole() {
    }

    public AppRole(Long id, String name, Set<UserRole> userRoleSet) {
        this.id = id;
        this.name = name;
        this.userRoleSet = userRoleSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
