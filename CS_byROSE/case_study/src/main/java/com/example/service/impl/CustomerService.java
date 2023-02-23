package com.example.service.impl;

import com.example.model.customer.Customer;
import com.example.repository.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> searchName(String name, String email, int customerTypeId, Pageable pageable) {
        return customerRepository.searchName(name, email, customerTypeId, pageable);
    }

    @Override
    public Page<Customer> searchName(String name, String email, Pageable pageable) {
        return customerRepository.searchName(name, email, pageable);
    }

    @Override
    public boolean addNewCustomer(Customer customer) {
        if (customerRepository.findByIdCard(customer.getIdCard()) != null) {
            return false;
        }
        try {
            customerRepository.save(customer);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean editCustomer(Customer customer) {
        if (!customerRepository.findById(customer.getId()).isPresent()) {
            return false;
        }
        try {
            customerRepository.save(customer);
        } catch (
                IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }
}
