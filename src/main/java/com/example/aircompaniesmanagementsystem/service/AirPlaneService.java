package com.example.aircompaniesmanagementsystem.service;

import com.example.aircompaniesmanagementsystem.dto.request.AirplaneRequest;
import com.example.aircompaniesmanagementsystem.dto.request.MoveAirplaneRequest;
import com.example.aircompaniesmanagementsystem.dto.response.AirplaneResponse;

public interface AirPlaneService {
    AirplaneResponse add(AirplaneRequest request);
    void reassignPlane(MoveAirplaneRequest request);
}
