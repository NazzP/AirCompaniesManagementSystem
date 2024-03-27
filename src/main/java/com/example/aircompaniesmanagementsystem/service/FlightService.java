package com.example.aircompaniesmanagementsystem.service;

import com.example.aircompaniesmanagementsystem.entity.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> findAllActiveFlightsStartedMoreThan24HoursAgo();
}
