package com.example.model.employee;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EmployeeDto implements Validator {
    @NotBlank(message = "tên nhân viên không thể để trống")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Tên nhân viên không thể chứa ký tự đặc biệt và không thể chứa số")
    private String name;
    private String dateOfBirth;

    @NotBlank(message = "số cmnd không thể để trống")
    @UniqueElements(message = "số cmnd đã tồn tại")
    @Pattern(regexp = "(\\d{9})|(\\d{12})",message = "số cmnd phải đúng định dạng,vd:XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCard;

    @NotBlank(message = "số điện thoại không được để trống")
    @Pattern(regexp = "(090\\d{7})|(091\\d{7})|(\\(84\\)\\+90\\d{7})|(\\(84\\)\\+91\\d{7})",message = "Số điện thoại phải đúng định dạng, vd:090xxxxxxx; 091xxxxxxx; (84)+90xxxxxxx; (84)+91xxxxxxx " )
    @UniqueElements(message = "số điện thoại bạn nhập đã tồn tại")
    private String phoneNumber;

    @Min(value = 1,message = "Lương phải là số dương")
    private Double salary;

    @Pattern(regexp = "[a-zA-Z]+\\w+@\\w+(\\.\\w+)+",message = "email phải đúng định dạng, vd: abc123@gmail.com")
    private String email;
    private String address;

    public EmployeeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
EmployeeDto employeeDto = (EmployeeDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        try {
            LocalDate dateOfBirth1 = LocalDate.parse(employeeDto.dateOfBirth, formatter);
        } catch (DateTimeParseException e) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Ngày sinh phải đúng định dạng dd/MM/yyyy");
        }
    }
}
