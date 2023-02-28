package com.codegym.user.repository;

import com.codegym.user.model.AppUser;
import com.codegym.user.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findAllByAppUser(AppUser appUser);
}
