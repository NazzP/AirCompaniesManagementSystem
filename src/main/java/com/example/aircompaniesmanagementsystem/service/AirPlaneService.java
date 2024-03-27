package com.example.aircompaniesmanagementsystem.service;

import com.example.aircompaniesmanagementsystem.dto.MoveAirplaneRequest;

public interface AirPlaneService {
    void reassignPlane(MoveAirplaneRequest request);
}
