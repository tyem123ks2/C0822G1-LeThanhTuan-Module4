package com.example.furama_resort_management.service.impl;

import com.example.furama_resort_management.model.customer.CustomerType;
import com.example.furama_resort_management.repository.ICustomerTypeRepository;
import com.example.furama_resort_management.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}
