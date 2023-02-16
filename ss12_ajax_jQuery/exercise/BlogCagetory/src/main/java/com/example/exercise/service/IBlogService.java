package com.example.exercise.service;

import com.example.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> searchTitle(String title, Pageable pageable);

    Page<Blog> findBlogByCategory(int id, Pageable pageable);

    List<Blog> findBlogByCategory(int id);

    Page<Blog> getAllBlog(Pageable pageable);

    boolean addNewBlog(Blog blog);

    boolean updateBlog(Blog blog);

    boolean removeBlog(int id);

    Optional<Blog> findBlogById(int id);

    List<Blog> findAll();
}
