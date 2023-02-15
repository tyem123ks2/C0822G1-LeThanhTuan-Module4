package com.example.exercise.controller.rest;

import com.example.exercise.model.Blog;
import com.example.exercise.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/blog")
public class BlogRestController {
    private IBlogService blogService;

    @GetMapping("show-list")
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> blogList = blogService.showAllBlog();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id).orElse(null);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }


}
