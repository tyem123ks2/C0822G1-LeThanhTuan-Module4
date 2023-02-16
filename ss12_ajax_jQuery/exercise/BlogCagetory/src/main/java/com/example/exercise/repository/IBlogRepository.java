package com.example.exercise.repository;

import com.example.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where title like concat('%',:name,'%') and is_deleted = false", nativeQuery = true)
    Page<Blog> searchTitle(@Param("name") String title, Pageable pageable);

    Blog findByTitle(String title);

    @Query(value = "select * from blog where category_id = :id and is_deleted = false", nativeQuery = true)
    Page<Blog> findBlogByCategory(@Param("id") int id, Pageable pageable);

    @Query(value = "select * from blog where is_deleted = false", nativeQuery = true)
    Page<Blog> getAllBlog(Pageable pageable);

    @Query(value = "select * from blog where category_id = :id and is_deleted = false", nativeQuery = true)
    List<Blog> findBlogByCategory(@Param("id") int id);

}
