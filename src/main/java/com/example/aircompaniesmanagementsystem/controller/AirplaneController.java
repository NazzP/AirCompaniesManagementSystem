package com.example.aircompaniesmanagementsystem.controller;

import com.example.aircompaniesmanagementsystem.dto.MoveAirplaneRequest;
import com.example.aircompaniesmanagementsystem.service.AirPlaneService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airplane")
public class AirplaneController {

    private final AirPlaneService airplaneService;

    public AirplaneController(AirPlaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PostMapping("/reassign")
    public void reassignCompany(@RequestBody MoveAirplaneRequest request){
        airplaneService.reassignPlane(request);
    }
}
