package com.example.furama_resort_management.service;

import com.example.furama_resort_management.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> searchName(String name, Pageable pageable);

    Page<Facility> searchNameAndFacilityType(String name, Integer typeId, Pageable pageable);

    boolean addNewFacility(Facility facility);

    boolean editFacility(Facility facility);

    Facility findById(int id);
}