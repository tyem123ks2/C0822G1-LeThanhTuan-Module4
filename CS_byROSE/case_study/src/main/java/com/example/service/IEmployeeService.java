package com.example.service;


import com.example.model.employee.Employee;
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
