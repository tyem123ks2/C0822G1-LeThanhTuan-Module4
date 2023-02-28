package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog_jpa.blog where title like concat('%',:title,'%')",nativeQuery = true)
    Page<Blog> findBlogByTitle(@Param("title") String title, Pageable pageable);

    @Query(value = "select * from blog where category_id = :categoryId",nativeQuery = true)
    Page<Blog> selectByCategory(@Param("categoryId") int categoryId,Pageable pageable);

    List<Blog> findBlogByTitleContaining(String title);
}
