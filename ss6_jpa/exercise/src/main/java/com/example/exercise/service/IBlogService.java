package com.example.exercise.service;

import com.example.exercise.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> showAllBlog();

    boolean addNewBlog(Blog blog);

    boolean updateBlog(Blog blog);

    boolean removeBlog(int id);

    Optional<Blog> findById(int id);

}
