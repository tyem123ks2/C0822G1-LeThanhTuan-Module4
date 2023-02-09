package com.example.register.repository;

import com.example.register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface IUserRepository extends JpaRepository<User,Integer> {
    List<User> findByLastName(String lastName);
}
