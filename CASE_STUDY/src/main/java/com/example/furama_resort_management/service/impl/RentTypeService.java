package com.example.furama_resort_management.service.impl;

import com.example.furama_resort_management.model.facility.RentType;
import com.example.furama_resort_management.repository.IRentTypeRepository;
import com.example.furama_resort_management.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> getAllRentType() {
        return rentTypeRepository.findAll();
    }
}
