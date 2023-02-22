package com.example.furama_resort_management.repository;

import com.example.furama_resort_management.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
