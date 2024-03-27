package com.example.aircompaniesmanagementsystem.repository;

import com.example.aircompaniesmanagementsystem.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
