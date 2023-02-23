package com.example.furama_resort_management.service;

import com.example.furama_resort_management.model.employee.Division;
import com.example.furama_resort_management.model.employee.EducationDegree;
import com.example.furama_resort_management.model.employee.Employee;
import com.example.furama_resort_management.model.employee.Position;
import exception.DataDuplicationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    Page<Employee> getEmployeePage(String name, String email, Pageable pageable);

//    List<Position> getPositionList();
//    List<Division> getDivisionList();
//    List<EducationDegree> getEducationDegreeList();
//    Employee addEmployee(Employee employee) throws DataDuplicationException;
}
