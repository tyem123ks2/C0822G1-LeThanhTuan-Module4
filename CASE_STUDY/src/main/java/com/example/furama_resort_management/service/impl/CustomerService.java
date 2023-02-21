package com.example.furama_resort_management.service.impl;

import com.example.furama_resort_management.model.customer.Customer;
import com.example.furama_resort_management.repository.ICustomerRepository;
import com.example.furama_resort_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> sreachName(String name, String email, int customerTypeId, Pageable pageable) {
        return customerRepository.searchName(name, email, customerTypeId, pageable);
    }

    @Override
    public Page<Customer> sreachName(String name, String email, Pageable pageable) {
        return customerRepository.searchName(name, email, pageable);
    }

    @Override
    public boolean addNewCustomer(Customer customer) {
        if (customerRepository.findByIdCard(customer.getIdCard()) == null){
            return false;
        }
        try {
            customerRepository.save(customer);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        if (customerRepository.findById(customer.getId()).isPresent()){
            return false;
        }
        try {
            customerRepository.save(customer);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e){
            return false;
        }
        return true;
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }
}
