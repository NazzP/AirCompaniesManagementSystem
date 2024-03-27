package com.example.aircompaniesmanagementsystem.service;

import com.example.aircompaniesmanagementsystem.dto.AirCompanyRequest;
import com.example.aircompaniesmanagementsystem.dto.AirCompanyResponse;
import com.example.aircompaniesmanagementsystem.entity.AirCompany;

import java.util.List;

public interface AirCompanyService {
    AirCompanyResponse create(AirCompanyRequest request);
    AirCompany read(long id);
    AirCompanyResponse update(AirCompanyRequest request);
    void delete(long id);
    List<AirCompany> getAll();
}
