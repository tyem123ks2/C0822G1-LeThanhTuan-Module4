package com.example.repository;

import com.example.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
