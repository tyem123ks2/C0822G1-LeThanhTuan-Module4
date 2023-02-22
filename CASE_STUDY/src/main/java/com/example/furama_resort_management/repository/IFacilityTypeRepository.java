package com.example.furama_resort_management.repository;

import com.example.furama_resort_management.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
}
