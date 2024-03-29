package com.example.aircompaniesmanagementsystem.controller;

import com.example.aircompaniesmanagementsystem.dto.request.AirCompanyRequest;
import com.example.aircompaniesmanagementsystem.dto.response.AirCompanyResponse;
import com.example.aircompaniesmanagementsystem.entity.AirCompany;
import com.example.aircompaniesmanagementsystem.entity.Flight;
import com.example.aircompaniesmanagementsystem.service.AirCompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircompany")
public class AirCompanyController {
    AirCompanyService airCompanyService;

    public AirCompanyController(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }

    @PostMapping("/create")
    public AirCompanyResponse create(@RequestBody AirCompanyRequest request){
        return airCompanyService.create(request);
    }

    @GetMapping("/read/{id}")
    public AirCompany read(@PathVariable Long id){
        return airCompanyService.read(id);
    }

    @PutMapping("/update")
    public AirCompanyResponse update(@RequestBody AirCompanyRequest request){
        return airCompanyService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        airCompanyService.delete(id);
    }

    @GetMapping("/{airCompanyName}/flights/{status}")
    public ResponseEntity<List<Flight>> findAllFlightsByStatus(
            @PathVariable String airCompanyName,
            @PathVariable String status) {

        List<Flight> flights = airCompanyService.findAllFlightsByStatus(airCompanyName, status);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
