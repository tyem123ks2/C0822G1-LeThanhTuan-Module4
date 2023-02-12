package com.example.register.dto;

import com.example.register.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.*;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.Set;

public class UserDto implements Validator {
    private int id;
    @NotNull(message = "Could not be void!")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Cannot contain numeric characters")
    private String firstName;
    @NotNull(message = "Could not be void!")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Cannot contain numeric characters")
    private String lastName;
    private String phoneNumber;
    @Min(value = 18, message = "Tuổi phải lớn hơn 18")
    private int age;
    @NotBlank(message = "không được để trống")
    @Min(value = 7)
    @Max(value = 64)
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Email không hợp lệ!!")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateProperty(T object, String propertyName, Class<?>... groups) {
        return null;
    }

    @Override
    public <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
        return null;
    }

    @Override
    public BeanDescriptor getConstraintsForClass(Class<?> clazz) {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> type) {
        return null;
    }

    @Override
    public ExecutableValidator forExecutables() {
        return null;
    }

    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
//        Xử lý validate First Name
//        Xử lý validate Phone Number
        String email = userDto.getEmail();
        String phoneNumber = userDto.getPhoneNumber();
        if (phoneNumber.length() < 10) {
            errors.rejectValue("phoneNumber", "phoneError1", "Số điện thoại nhập sai!");
        } else if (phoneNumber.length() > 11) {
            errors.rejectValue("phoneNumber", "phoneError2", "Số điện thoại nhập sai!");
        } else if (!phoneNumber.matches("^[0-9]+$")) {
            errors.rejectValue("phoneNumber", "phoneError3", "Số điện thoại nhập sai!");
        }
    }
}
