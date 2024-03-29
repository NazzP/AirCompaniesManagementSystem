package com.example.aircompaniesmanagementsystem.service;

import com.example.aircompaniesmanagementsystem.dto.request.AirCompanyRequest;
import com.example.aircompaniesmanagementsystem.dto.response.AirCompanyResponse;
import com.example.aircompaniesmanagementsystem.entity.AirCompany;
import com.example.aircompaniesmanagementsystem.entity.Flight;

import java.util.List;

public interface AirCompanyService {
    AirCompanyResponse create(AirCompanyRequest request);
    AirCompany read(long id);
    AirCompanyResponse update(AirCompanyRequest request);
    void delete(long id);
    List<Flight> findAllFlightsByStatus(String airCompanyName, String status);
}
