package com.example.furama_resort_management.service;

import com.example.furama_resort_management.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> sreachName(String name, String email, int customerTypeId, Pageable pageable);

    Page<Customer> sreachName(String name, String email, Pageable pageable);

    boolean addNewCustomer(Customer customer);

    boolean editCustomer(Customer customer);

    Customer findById(int id);
}
