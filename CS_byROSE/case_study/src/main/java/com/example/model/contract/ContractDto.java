package com.example.model.contract;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ContractDto implements Validator {
    private String startDate;
    private String endDate;
    @Min(value = 1,message = "Tiền đặt cọc phải là số dương")
    private Double deposit;
    private Customer customer;
    private Employee employee;
    private Facility facility;
    private ContractDetail contractDetail;

    public ContractDto() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public ContractDetail getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(ContractDetail contractDetail) {
        this.contractDetail = contractDetail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        try {
            LocalDate startDate1 = LocalDate.parse(contractDto.startDate, formatter);
        } catch (DateTimeParseException e) {
            errors.rejectValue("startDate", "startDate", "Ngày bắt đầu phải đúng định dạng dd/MM/yyyy");
        }
        try {
            LocalDate endDate1 = LocalDate.parse(contractDto.endDate, formatter);
        } catch (DateTimeParseException e) {
            errors.rejectValue("endDate", "endDate", "Ngày kết thúc phải đúng định dạng dd/MM/yyyy");
        }
    }
}
