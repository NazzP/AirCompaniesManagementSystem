package com.example.aircompaniesmanagementsystem.repository;

import com.example.aircompaniesmanagementsystem.entity.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
    Boolean existsByName(String email);
    Optional<AirCompany> findByName(String name);
}
