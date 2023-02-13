package com.example.borrowbooks.service;

import com.example.borrowbooks.model.History;

import java.util.Optional;

public interface IHistoryService {
    Optional<History> getBooksByCode(int code);

    boolean deleteHistory(int code);

    boolean addHistory(History history);
}
