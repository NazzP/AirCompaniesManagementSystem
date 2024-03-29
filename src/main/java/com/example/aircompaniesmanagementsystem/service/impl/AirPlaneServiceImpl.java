package com.example.aircompaniesmanagementsystem.service.impl;

import com.example.aircompaniesmanagementsystem.aspect.ToValidate;
import com.example.aircompaniesmanagementsystem.dto.info.AirplaneInfo;
import com.example.aircompaniesmanagementsystem.dto.request.AirplaneRequest;
import com.example.aircompaniesmanagementsystem.dto.request.MoveAirplaneRequest;
import com.example.aircompaniesmanagementsystem.dto.response.AirplaneResponse;
import com.example.aircompaniesmanagementsystem.entity.AirCompany;
import com.example.aircompaniesmanagementsystem.entity.Airplane;
import com.example.aircompaniesmanagementsystem.exception.NullEntityReferenceException;
import com.example.aircompaniesmanagementsystem.repository.AirCompanyRepository;
import com.example.aircompaniesmanagementsystem.repository.AirplaneRepository;
import com.example.aircompaniesmanagementsystem.service.AirPlaneService;
import com.example.aircompaniesmanagementsystem.utils.ResponseUtils;
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
    // @ToValidate
    public AirplaneResponse add(AirplaneRequest request) {

        if (airplaneRepository.existsByFactorySerialNumber(request.getFactorySerialNumber())) {
            return AirplaneResponse.builder()
                    .responseCode(ResponseUtils.AIRPLANE_EXISTS_CODE)
                    .responseMessage(ResponseUtils.AIRPLANE_EXISTS_MESSAGE)
                    .airplaneInfo(null)
                    .build();
        }

        /*if you want to reject a situation where the AirCompany can be null: ( line 28 - uncomment @ToValidate )
         * uncomment lines 46-48
         * delete lines 51-57
         * in line 76 change ( "newAirplane.getAirCompany() != null ? newAirplane.getAirCompany().getId() : null" to
         * newAirplane.getAirCompany().getId()
         * */

        /*AirCompany existingAirCompany = airCompanyRepository.findById(request.getAirCompanyId()).orElseThrow(
                () -> new NullEntityReferenceException("AirCompany with id " + request.getAirCompanyId() + " not found")
        );*/


        // if you want to accept a situation where the company can be zero
        Long airCompanyId = request.getAirCompanyId();
        AirCompany existingAirCompany = null;

        if (airCompanyId != null) {
            existingAirCompany = airCompanyRepository.findById(airCompanyId).orElse(null);
        }


        Airplane newAirplane = Airplane.builder()
                .factorySerialNumber(request.getFactorySerialNumber())
                .airCompany(existingAirCompany)
                .numberOfFlights(request.getNumberOfFlights())
                .flightDistance(request.getFlightDistance())
                .fuelCapacity(request.getFuelCapacity())
                .type(request.getType())
                .build();

        airplaneRepository.save(newAirplane);

        return AirplaneResponse.builder()
                .responseCode(ResponseUtils.AIRPLANE_CREATION_SUCCESSFULLY_CODE)
                .responseMessage(ResponseUtils.AIRPLANE_CREATION_SUCCESS_MESSAGE)
                .airplaneInfo(AirplaneInfo.builder()
                        .factorySerialNumber(newAirplane.getFactorySerialNumber())
                        .airCompanyId(newAirplane.getAirCompany() != null ? newAirplane.getAirCompany().getId() : null)
                        .numberOfFlights(newAirplane.getNumberOfFlights())
                        .flightDistance(newAirplane.getFlightDistance())
                        .fuelCapacity(newAirplane.getFuelCapacity())
                        .type(newAirplane.getType())
                        .createdAt(newAirplane.getCreatedAt())
                        .build())
                .build();
    }

    @Override
    @ToValidate
    public void reassignPlane(MoveAirplaneRequest request) {
        Airplane existingAirplane = airplaneRepository.findById(request.getAirPlaneId()).orElseThrow(
                () -> new NullEntityReferenceException("AirPlane with id " + request.getAirPlaneId() + " not found")
        );
        AirCompany existingAirCompany = airCompanyRepository.findById(request.getAirCompanyId()).orElseThrow(
                () -> new NullEntityReferenceException("AirCompany with id " + request.getAirCompanyId() + " not found")
        );

        existingAirplane.setAirCompany(existingAirCompany);
        airplaneRepository.save(existingAirplane);
    }
}
