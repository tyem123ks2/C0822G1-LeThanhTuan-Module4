package com.example.register.service;

import com.example.register.model.User;
import org.springframework.validation.Errors;

import java.util.List;

public interface IUserService {

    List<User> showList();

    boolean addNewUser(User user);

    boolean updateUser(User blog);
}
