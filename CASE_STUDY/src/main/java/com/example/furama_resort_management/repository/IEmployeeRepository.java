package com.example.furama_resort_management.repository;

import com.example.furama_resort_management.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where name like concat('%',:name,'%') and email like concat('%',:email,'%')",nativeQuery = true)
    Page<Employee> getEmployeePage(@Param("name") String name, @Param("email") String email, Pageable pageable);

    Employee findByIdCard(String idCard);
    Employee findByEmail(String email);
    Employee findByPhoneNumber(String phoneNumber);
}
