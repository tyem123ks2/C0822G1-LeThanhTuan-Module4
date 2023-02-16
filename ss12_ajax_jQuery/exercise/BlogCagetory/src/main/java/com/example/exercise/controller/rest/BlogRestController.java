package com.example.exercise.controller.rest;

import com.example.exercise.model.Blog;
import com.example.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/blogs")
@CrossOrigin("*")
public class BlogRestController {

    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "/show-detail/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
        Blog blog = blogService.findBlogById(id).orElse(null);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping(value = "/show-list-by-category?id={id}&size={size}")
    public ResponseEntity<Page<Blog>> getBlogsByCategory(@RequestParam(value = "id", defaultValue = "0") int id,
                                                         @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<Blog> blogPage;
        Pageable pageable = PageRequest.of(0, size);
        if (id==0) {
            blogPage = blogService.getAllBlog(pageable);
        } else {
            blogPage = blogService.findBlogByCategory(id, pageable);
        }
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }


}