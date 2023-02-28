package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategoryList(){
        List<Category> categoryList = categoryService.findAll();
            if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Blog>> getBlogList(){
        List<Blog> blogList = blogService.findAll();
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping("/searchCategory/{id}")
    public ResponseEntity<Page<Blog>> searchByCategory(@PathVariable("id") int categoryId, @PageableDefault(size = 2) Pageable pageable){
        Page<Blog> blogs = blogService.selectByCategory(categoryId,pageable);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping ("/searchBlogByTitle")
    public ResponseEntity<List<Blog>> searchByCategory(@RequestParam("title") String title){
        List<Blog> blogs = blogService.findBlogByTitleContaining(title);
//        if(blogs.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/searchBlogById/{id}")
    public ResponseEntity<Blog> searchBlogById(@PathVariable("id") int id){
        Blog blog = blogService.findById(id).orElse(null);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
