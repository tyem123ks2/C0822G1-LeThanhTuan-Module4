package com.example.borrowbooks.service;

import com.example.borrowbooks.exception.InvalidCodeException;
import com.example.borrowbooks.exception.OutOfBooksException;
import com.example.borrowbooks.model.Books;

import java.util.List;

public interface IBooksService {
    List<Books> showList();

    Integer borrowBooks(int id) throws OutOfBooksException;

    boolean returnBooks(int code) throws InvalidCodeException;
}
