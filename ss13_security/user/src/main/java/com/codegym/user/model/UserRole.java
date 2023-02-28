package com.codegym.user.model;


import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    AppUser appUser;


    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    AppRole appRole;


    public UserRole() {
    }

    public UserRole(Long id, AppUser appUser, AppRole appRole) {
        this.id = id;
        this.appUser = appUser;
        this.appRole = appRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
