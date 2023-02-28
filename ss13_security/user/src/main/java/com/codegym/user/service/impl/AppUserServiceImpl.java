package com.codegym.user.service.impl;

import com.codegym.user.model.AppUser;
import com.codegym.user.model.UserRole;
import com.codegym.user.repository.AppRoleRepository;
import com.codegym.user.repository.AppUserRepository;
import com.codegym.user.repository.UserRoleRepository;
import com.codegym.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public void save(AppUser appUser) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));

        appUser = appUserRepository.save(appUser);
        UserRole userRole = new UserRole();

        userRole.setAppRole(appRoleRepository.findById((long) 3).get());
        userRole.setAppUser(appUser);

        userRoleRepository.save(userRole);
    }
}
