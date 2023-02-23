package com.example.service.impl;

import com.example.model.facility.RentType;
import com.example.repository.IRentTypeRepository;
import com.example.service.IRentTypeService;
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
