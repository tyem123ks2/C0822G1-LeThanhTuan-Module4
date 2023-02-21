package com.example.furama_resort_management.model.employee;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dateOfBirth;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private EducationDegree educationDegree;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Division division;

    @OneToOne
    private User user;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, double salary, String phoneNumber, String email, String address,
                    Position position, EducationDegree educationDegree, boolean isDeleted, User user) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.isDeleted = isDeleted;
        this.user = user;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
