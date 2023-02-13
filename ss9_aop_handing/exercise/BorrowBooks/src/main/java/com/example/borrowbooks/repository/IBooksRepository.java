package com.example.borrowbooks.repository;

import com.example.borrowbooks.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBooksRepository extends JpaRepository<Books, Integer> {

}
