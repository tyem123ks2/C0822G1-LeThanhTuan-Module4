package com.example.exercise.service;

import com.example.exercise.model.Blog;
import com.example.exercise.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICagetoryService {
    List<Category> showAllCategory();

    boolean addNewCategory(Category category);

    boolean updateCategory(Category category);

    boolean removeCategory(int id);

    Optional<Category> findById(int id);

    Page<Category> findByNameCategory(String name, Pageable pageable);
}
