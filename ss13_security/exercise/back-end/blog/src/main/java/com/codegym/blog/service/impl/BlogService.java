package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }



    @Override
    public boolean add(Blog blog) {
        for (int i = 0; i < findAll().size(); i++) {
            if (findAll().get(i).getTitle().equals(blog.getTitle())) {
                return false;
            }
        }
        blogRepository.save(blog);
        return true;
    }

    @Override
    public boolean edit(Blog blog) {
        for (int i = 0; i < findAll().size(); i++) {
            if (findAll().get(i).getTitle().equals(blog.getTitle())) {
                return false;
            }
        }
        blogRepository.save(blog);
        return true;
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findBlogByTitle(String title, Pageable pageable) {
        return blogRepository.findBlogByTitle(title,pageable);
    }

    @Override
    public List<Blog> findBlogByTitleContaining(String title) {
        return blogRepository.findBlogByTitleContaining(title);
    }

    @Override
    public Page<Blog> selectByCategory(int categoryId,Pageable pageable) {
        return blogRepository.selectByCategory(categoryId,pageable);
    }


}
