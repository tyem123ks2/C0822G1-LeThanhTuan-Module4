package com.example.model.customer;

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

    @NotBlank(message = "tên khách hàng không được để trống")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$", message = "Tên khách hàng không thể chứa ký tự đặc biệt và không thể chứa số")
    private String name;
    private int gender;

    @NotBlank(message = "số cmnd không được để trống")
    @Pattern(regexp = "(\\d{9})|(\\d{12})", message = "số cmnd phải đúng định dạng,vd:XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCard;

    @Pattern(regexp = "(090\\d{7})|(091\\d{7})|(\\(84\\)\\+90\\d{7})|(\\(84\\)\\+91\\d{7})", message = "Số điện thoại phải đúng định dạng, vd:090xxxxxxx; 091xxxxxxx; (84)+90xxxxxxx; (84)+91xxxxxxx ")
    @NotBlank(message = "số điện thoại không được để trống")
    private String phoneNumber;
    @Pattern(regexp = "[a-zA-Z]+\\w+@\\w+(\\.\\w+)+", message = "email phải đúng định dạng, vd: abc123@gmail.com")
    private String email;


    private String address;

    public CustomerDto() {
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        try {
            LocalDate dateOfBirth1 = LocalDate.parse(customerDto.dateOfBirth, formatter);
        } catch (DateTimeParseException e) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Ngày sinh phải đúng định dạng dd/MM/yyyy");
        }
        //validate name
        String strRegex = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
        String[] names = customerDto.getName().split(" ");
        String upperRegex = "[A-Z]";
        if (!customerDto.getName().matches(strRegex)) {
            errors.rejectValue("name", "name", "Tên khách hàng không được chứa ký tự đặc biệt và chứa số");
            return;
        }
        char firstLetter;
        for (int i = 0; i < names.length; i++) {
            firstLetter = names[i].charAt(0);
            if (firstLetter < 'A' || firstLetter > 'Z') {
                errors.rejectValue("name", "name", "Ký tự đầu tiên phải viết hoa");
            }
        }

    }
}
