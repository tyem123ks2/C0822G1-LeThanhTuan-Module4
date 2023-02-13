package com.example.borrowbooks.repository;

import com.example.borrowbooks.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHistoryRepository extends JpaRepository<History, Integer> {
}
