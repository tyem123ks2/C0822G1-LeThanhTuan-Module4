package com.example.furama_resort_management.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employeeList;

    public EducationDegree() {
    }

    public EducationDegree(int id, String name, boolean isDeleted, List<Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
        this.employeeList = employeeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
