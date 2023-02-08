package com.example.exercise.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Blog> blog;
}
