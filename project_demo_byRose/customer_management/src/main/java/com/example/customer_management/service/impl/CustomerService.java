package com.example.customer_management.service.impl;

import com.example.customer_management.model.Customer;
import com.example.customer_management.repository.ICustomerRepository;
import com.example.customer_management.service.ICustomerService;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> showCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public boolean addNewCustomer(Customer customer) {
        try {
            if (customerRepository.findByFirstName(customer.getFirstName()) == null){
                throw new SQLDataException();
            }
            customerRepository.save(customer);
        } catch (IllegalArgumentException | OptimisticEntityLockException | SQLDataException e) {
             return false;
        }
        return true;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        if (!customerRepository.existsById(Math.toIntExact(customer.getId()))){
            return false;
        }
        try {
            customerRepository.save(customer);
        } catch (IllegalArgumentException | OptimisticEntityLockException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeCustomer(Long id) {
        try {
            customerRepository.deleteById(Math.toIntExact(id));
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(Math.toIntExact(id));
    }
}
