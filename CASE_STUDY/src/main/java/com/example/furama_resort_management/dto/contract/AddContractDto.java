package com.example.furama_resort_management.dto.contract;

import com.example.furama_resort_management.model.customer.Customer;
import com.example.furama_resort_management.model.employee.Employee;
import com.example.furama_resort_management.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AddContractDto implements Validator {
    private int id;
    private String startDate;
    private String endDate;
    @NotBlank
    @Min(value = 1, message = "Tiền đặt cọc phải là số dương")
    private Double deposit;
    private Customer customer;
    private Employee employee;
    private Facility facility;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AddContractDto addContractDto = (AddContractDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate newStartDate = null;
        LocalDate newEndDate = null;
        if (startDate != "") {
            try {
                newStartDate = LocalDate.parse(addContractDto.startDate, formatter);
            } catch (DateTimeParseException e) {
                errors.rejectValue("startDate", "startDate", "Ngày bắt đầu yêu cầu đúng định dạng dd/MM/yyyy");
            }
        } else {
            errors.rejectValue("startDate", "startDate", "Vui lòng nhập ngày bắt đầu");
        }
        if (endDate != "") {
            try {
                newEndDate = LocalDate.parse(addContractDto.endDate, formatter);
                if (newEndDate != null && newStartDate != null) {
                    Period period = Period.between(newStartDate, newEndDate);
                    if (period.isZero() || period.isNegative()) {
                        errors.rejectValue("endDate", "endDate", "Ngày kết thúc phải lớn hơn ngày bắt đầu ít nhất là 1 ngày");
                    }
                }
            } catch (DateTimeParseException e) {
                errors.rejectValue("endDate", "endDate", "Ngày kết thúc phải đúng định dạng dd/MM/yyyy");
            }
        } else {
            errors.rejectValue("endDate", "endDate", "Vui lòng nhập ngày kết thúc");
        }
        if (addContractDto.getDeposit() != null) {
            if (addContractDto.getDeposit() <= 0) {
                errors.rejectValue("deposit", "deposit", "Tiền cọc phải lớn hơn 0");
            }
        } else {
            errors.rejectValue("deposit", "deposit", "Vui lòng nhập tiền cọc");
        }

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
}
