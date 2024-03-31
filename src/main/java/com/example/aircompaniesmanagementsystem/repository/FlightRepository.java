package com.example.aircompaniesmanagementsystem.repository;

import com.example.aircompaniesmanagementsystem.entity.Flight;
import com.example.aircompaniesmanagementsystem.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f WHERE f.flightStatus = :status")
    List<Flight> findAllByStatus(Status status);
}
