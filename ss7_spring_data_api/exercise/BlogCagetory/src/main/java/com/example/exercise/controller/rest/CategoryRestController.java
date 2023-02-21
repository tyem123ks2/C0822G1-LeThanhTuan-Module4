package com.example.exercise.controller.rest;

import com.example.exercise.model.Category;
import com.example.exercise.service.ICagetoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/category")
public class CategoryRestController {
    @Autowired
    private ICagetoryService cagetoryService;

    @GetMapping("show-list")
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categoryList = cagetoryService.showAllCategory();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

}
