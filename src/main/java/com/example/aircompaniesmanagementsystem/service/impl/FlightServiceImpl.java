package com.example.aircompaniesmanagementsystem.service.impl;

import com.example.aircompaniesmanagementsystem.entity.Flight;
import com.example.aircompaniesmanagementsystem.entity.Status;
import com.example.aircompaniesmanagementsystem.repository.FlightRepository;
import com.example.aircompaniesmanagementsystem.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> findAllActiveFlightsStartedMoreThan24HoursAgo() {
        return flightRepository.findAllByStatus(Status.ACTIVE).stream()
                .filter(flight -> flight.getStartedAt().isAfter(LocalDateTime.now().minusDays(1)))
                .collect(Collectors.toList());
    }
}
