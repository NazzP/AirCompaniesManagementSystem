package com.example.aircompaniesmanagementsystem.service.impl;

import com.example.aircompaniesmanagementsystem.dto.MoveAirplaneRequest;
import com.example.aircompaniesmanagementsystem.entity.AirCompany;
import com.example.aircompaniesmanagementsystem.entity.Airplane;
import com.example.aircompaniesmanagementsystem.exception.NullEntityReferenceException;
import com.example.aircompaniesmanagementsystem.repository.AirCompanyRepository;
import com.example.aircompaniesmanagementsystem.repository.AirplaneRepository;
import com.example.aircompaniesmanagementsystem.service.AirPlaneService;
import org.springframework.stereotype.Service;

@Service
public class AirPlaneServiceImpl implements AirPlaneService {
    AirplaneRepository airplaneRepository;
    AirCompanyRepository airCompanyRepository;

    public AirPlaneServiceImpl(AirplaneRepository airplaneRepository, AirCompanyRepository airCompanyRepository) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public void reassignPlane(MoveAirplaneRequest request) {
        Airplane existingAirplane = airplaneRepository.findById(request.getAirPlaneId()).orElseThrow(
                () -> new NullEntityReferenceException()
        );
        AirCompany existingAirCompany = airCompanyRepository.findById(request.getAirCompanyId()).orElseThrow(
                () -> new NullEntityReferenceException()
        );

        existingAirplane.setAirCompany(existingAirCompany);
        airplaneRepository.save(existingAirplane);
    }
}
