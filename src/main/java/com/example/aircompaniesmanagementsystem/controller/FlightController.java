package com.example.aircompaniesmanagementsystem.controller;

import com.example.aircompaniesmanagementsystem.entity.Flight;
import com.example.aircompaniesmanagementsystem.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/active-and-started-more-than-24-hours-ago")
    public ResponseEntity<List<Flight>> findAllFlightsByStatus() {
        List<Flight> flights = flightService.findAllActiveFlightsStartedMoreThan24HoursAgo();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
