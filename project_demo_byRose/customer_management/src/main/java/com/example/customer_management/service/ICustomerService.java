package com.example.customer_management.service;

import com.example.customer_management.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> showCustomerList();

    boolean addNewCustomer(Customer customer);

    boolean updateCustomer(Customer customer);

    boolean removeCustomer(Long id);

    Optional<Customer> findById(Long id);
}
