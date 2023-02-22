package com.example.furama_resort_management.service.impl;

import com.example.furama_resort_management.model.facility.Facility;
import com.example.furama_resort_management.repository.IFacilityRepository;
import com.example.furama_resort_management.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> searchName(String name, Pageable pageable) {
        return facilityRepository.sreachName(name, pageable);
    }

    @Override
    public Page<Facility> searchNameAndFacilityType(String name, Integer typeId, Pageable pageable) {
        return facilityRepository.sreachName(name, typeId, pageable);
    }

    @Override
    public boolean addNewFacility(Facility facility) {
        if (facilityRepository.findByName(facility.getName()) == null) {
            return false;
        }
        try {
            facilityRepository.save(facility);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean editFacility(Facility facility) {
        if (facilityRepository.findById(facility.getId()).isPresent()) {
            return false;
        }
        try {
            facilityRepository.save(facility);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }
}
