package com.example.repository;

import com.example.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();

    void update(Email email);

    Email findById(int id);

    List<String> findLanguage();

    List<Integer> findPageSize();
}
