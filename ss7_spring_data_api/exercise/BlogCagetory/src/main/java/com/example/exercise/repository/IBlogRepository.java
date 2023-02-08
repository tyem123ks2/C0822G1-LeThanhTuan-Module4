package com.example.exercise.repository;

import com.example.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitle(String title);

    Page<Blog> findByTitleCategory(String title, Pageable pageable);

//    @Query(value = "select * from Blog where title", nativeQuery = true)
//    List<Blog> sreach(@Param("title") String title);
}
