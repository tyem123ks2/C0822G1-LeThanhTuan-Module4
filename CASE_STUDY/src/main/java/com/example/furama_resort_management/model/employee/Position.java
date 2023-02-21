package com.example.furama_resort_management.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Position {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "position")
    private List<Employee> employeeList;
}
