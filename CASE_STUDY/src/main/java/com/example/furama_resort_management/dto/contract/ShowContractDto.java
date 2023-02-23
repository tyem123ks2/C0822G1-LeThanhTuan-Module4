package com.example.furama_resort_management.dto.contract;

import com.example.furama_resort_management.model.contract.ContractDetail;
import com.example.furama_resort_management.model.customer.Customer;
import com.example.furama_resort_management.model.employee.Employee;
import com.example.furama_resort_management.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;


public class ShowContractDto implements Validator {
    private int id;
    private String startDate;
    private String endDate;
    @Min(value = 1, message = "Tiền đặt cọc phải là số dương")
    private Double deposit;
    private Customer customer;
    private Employee employee;
    private Facility facility;
    private List<ContractDetail> contractDetail;
    private Double total;
    private String editHistory;

    public String getEditHistory() {
        return editHistory;
    }

    public void setEditHistory(String editHistory) {
        this.editHistory = editHistory;
    }

    public ShowContractDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(List<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ShowContractDto contractDto = (ShowContractDto) target;
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