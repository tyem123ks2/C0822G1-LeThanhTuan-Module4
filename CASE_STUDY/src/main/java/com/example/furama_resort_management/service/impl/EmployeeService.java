package com.example.furama_resort_management.service.impl;

import com.example.furama_resort_management.model.employee.Employee;
import com.example.furama_resort_management.repository.IEmployeeRepository;
import com.example.furama_resort_management.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> getEmployeePage(String name, String email, Pageable pageable) {
        return employeeRepository.getEmployeePage(name, email, pageable);
    }
}