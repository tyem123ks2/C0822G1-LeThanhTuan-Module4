package com.example.customer_management.service;

public interface ICustomerService<T> {
    Iterable<T> findAll();


}
