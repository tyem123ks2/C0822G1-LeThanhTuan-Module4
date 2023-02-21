package com.example.furama_resort_management.model.customer;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;
    private String name;
    private String dateOfBirth;
    private int gender;
    @Column(columnDefinition = "varchar(255) unique")
    private String idCard;

    @Column(columnDefinition = "varchar(255) unique")
    private String phoneNumber;

    @Column(columnDefinition = "varchar(255) unique")
    private String email;
    private String address;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    public Customer() {
    }

    public Customer(int id, CustomerType customerType, String name, String dateOfBirth, int gender, String idCard, String phoneNumber, String email, String address, boolean isDeleted) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.isDeleted = isDeleted;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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

    public int isGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public String getIdCard() {
        return idCard;
    }

}
