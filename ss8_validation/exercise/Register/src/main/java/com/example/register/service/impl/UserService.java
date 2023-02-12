package com.example.register.service.impl;

import com.example.register.model.User;
import com.example.register.repository.IUserRepository;
import com.example.register.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import java.sql.SQLDataException;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> showUserList() {

        return userRepository.findAll();
    }

    @Override
    public boolean addNewUser(User user) {
        try {
            if (userRepository.findByLastName(user.getLastName()) == null) {
                throw new SQLDataException();
            }
            userRepository.save(user);
        } catch (IllegalArgumentException | OptimisticLockingFailureException | SQLDataException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            return false;
        }
        try {
            userRepository.save(user);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
