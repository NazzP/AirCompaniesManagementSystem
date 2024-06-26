package com.example.aircompaniesmanagementsystem.controller;

import com.example.aircompaniesmanagementsystem.dto.request.FlightRequest;
import com.example.aircompaniesmanagementsystem.dto.response.FlightResponse;
import com.example.aircompaniesmanagementsystem.entity.Flight;
import com.example.aircompaniesmanagementsystem.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.aircompaniesmanagementsystem.entity.Status;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/add")
    public FlightResponse add(@RequestBody FlightRequest request) {
        return flightService.add(request);
    }

    @PostMapping("/changeStatus")
    public FlightResponse changeStatus(@RequestParam Long flightId,
                                       @RequestParam String status) {
        return flightService.changeStatus(flightId, status);
    }

    @GetMapping("/active-and-started-more-than-24-hours-ago")
    public ResponseEntity<List<Flight>> findAllFlightsByStatus() {
        List<Flight> flights = flightService.findAllActiveFlightsStartedMoreThan24HoursAgo();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/completedFlightsWithTimeDifferenceExceeded")
    public ResponseEntity<List<Flight>> getCompletedFlightsWithTimeDifferenceExceeded() {
        List<Flight> flights = flightService.findFlightsWithCompletedStatusAndTimeDifferenceExceeded();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

}
