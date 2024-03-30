package com.example.aircompaniesmanagementsystem.service;

import com.example.aircompaniesmanagementsystem.dto.request.FlightRequest;
import com.example.aircompaniesmanagementsystem.dto.response.FlightResponse;
import com.example.aircompaniesmanagementsystem.entity.Flight;
import com.example.aircompaniesmanagementsystem.entity.Status;

import java.util.List;

public interface FlightService {
    FlightResponse add(FlightRequest request);
    FlightResponse changeStatus(Long id, String status);
    List<Flight> findAllActiveFlightsStartedMoreThan24HoursAgo();
}
