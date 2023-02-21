package com.example.furama_resort_management.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FacilityDto implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
