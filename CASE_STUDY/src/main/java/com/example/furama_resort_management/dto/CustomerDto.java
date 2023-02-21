package com.example.furama_resort_management.dto;

import com.example.furama_resort_management.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomerDto implements Validator {
    private int id;
    private CustomerType customerType;
    private String dateOfBirth;

    @NotBlank(message = "Tên không được để trống!")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Tên sai định dạng! (không được có số và kí tự đặc biệt)")
    private String name;
    private int gender;

    @NotBlank(message = "CMND không được để trống!")
    @Pattern(regexp = "(\\d{9})|(\\d{12})", message = "CMND sai định dạng, VD:XXXXXXXXX (X là số 0-9).")
    private String idCard;

    @Pattern(regexp = "(0\\d{9})|(0\\d{9})|(\\(84\\)\\+\\d{9})|(\\(84\\)\\+\\d{9})", message = "SĐT sai định dạng, VD:0xxxxxxxxx; (84)+xxxxxxxxx ")
    @NotBlank(message = "SĐT không được để trống")
    private String phoneNumber;
    @NotBlank(message = "Email không được để trống!")
    @Pattern(regexp = "[a-zA-Z]+\\w+@\\w+(\\.\\w+)+", message = "Email sai định dạng, vd: abcd1234@gmail.com")
    private String email;

    private String address;

    public CustomerDto() {
    }

    public CustomerDto(int id, CustomerType customerType, String dateOfBirth, String name, int gender, String idCard, String phoneNumber, String email, String address) {
        this.id = id;
        this.customerType = customerType;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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
        CustomerDto customerDto = (CustomerDto) target;

        //validate dateOfBirth
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        try {
            LocalDate dateOfBirth1 = LocalDate.parse(customerDto.dateOfBirth, formatter);
        } catch (DateTimeParseException e) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Ngày sinh phải đúng định dạng. VD: dd/MM/yyyy");
        }

        //validate name
        String strRegex = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
        String[] names = customerDto.getName().split(" ");
        String upperRegex = "[A-Z]";
        if (!customerDto.getName().matches(strRegex)) {
            errors.rejectValue("name", "name", "Tên khách hàng không được chứa ký tự đặc biệt và chứa số");
        }
    }
}
