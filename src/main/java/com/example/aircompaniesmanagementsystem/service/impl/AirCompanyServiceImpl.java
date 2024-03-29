package com.example.aircompaniesmanagementsystem.service.impl;

import com.example.aircompaniesmanagementsystem.aspect.ToValidate;
import com.example.aircompaniesmanagementsystem.dto.info.AirCompanyInfo;
import com.example.aircompaniesmanagementsystem.dto.request.AirCompanyRequest;
import com.example.aircompaniesmanagementsystem.dto.response.AirCompanyResponse;
import com.example.aircompaniesmanagementsystem.entity.AirCompany;
import com.example.aircompaniesmanagementsystem.entity.Flight;
import com.example.aircompaniesmanagementsystem.repository.AirCompanyRepository;
import com.example.aircompaniesmanagementsystem.service.AirCompanyService;
import com.example.aircompaniesmanagementsystem.utils.ResponseUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {
    private final AirCompanyRepository airCompanyRepository;

    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    @ToValidate
    public AirCompanyResponse create(AirCompanyRequest request) {

        if (airCompanyRepository.existsByName(request.getName())){
            return AirCompanyResponse.builder()
                    .responseCode(ResponseUtils.AIRCOMPANY_EXISTS_CODE)
                    .responseMessage(ResponseUtils.AIRCOMPANY_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        AirCompany newAirCompany = AirCompany.builder()
                .name(request.getName())
                .companyType(request.getCompanyType())
                .foundedAt(request.getFoundedAt())
                .build();

        airCompanyRepository.save(newAirCompany);

        return AirCompanyResponse.builder()
                .responseCode(ResponseUtils.AIRCOMPANY_CREATION_SUCCESSFULLY_CODE)
                .responseMessage(ResponseUtils.AIRCOMPANY_CREATION_SUCCESS_MESSAGE)
                .accountInfo(AirCompanyInfo.builder()
                        .name(newAirCompany.getName())
                        .companyType(newAirCompany.getCompanyType())
                        .foundedAt(newAirCompany.getFoundedAt())
                        .build())
                .build();

    }

    @Override
    public AirCompany read(long id) {
        Optional<AirCompany> airCompanyOptional = airCompanyRepository.findById(id);
        return airCompanyOptional.orElseThrow(() -> new EntityNotFoundException("AirCompany with id " + id + " not found"));
    }

    @Override
    @ToValidate
    public AirCompanyResponse update(AirCompanyRequest request) {
        Optional<AirCompany> existingAirCompanyOptional = airCompanyRepository.findByName(request.getName());

        AirCompany existingAirCompany = existingAirCompanyOptional.orElseThrow(
                () -> new EntityNotFoundException("Aircompany with name" +request.getName() +"doesn't exist")
        );

        existingAirCompany.setCompanyType(request.getCompanyType());
        existingAirCompany.setFoundedAt(request.getFoundedAt());

        airCompanyRepository.save(existingAirCompany);

        return AirCompanyResponse.builder()
                .responseCode(ResponseUtils.AIRCOMPANY_UPDATION_SUCCESSFULLY_CODE)
                .responseMessage(ResponseUtils.AIRCOMPANY_UPDATION_SUCCESS_MESSAGE)
                .accountInfo(AirCompanyInfo.builder()
                        .name(existingAirCompany.getName())
                        .companyType(existingAirCompany.getCompanyType())
                        .foundedAt(existingAirCompany.getFoundedAt())
                        .build())
                .build();
    }

    @Override
    public void delete(long id) {
        Optional<AirCompany> airCompanyOptional = airCompanyRepository.findById(id);
        AirCompany existingAirCompany = airCompanyOptional.orElseThrow(EntityNotFoundException::new);
        airCompanyRepository.delete(existingAirCompany);
    }

    @Override
    public List<Flight> findAllFlightsByStatus(String airCompanyName, String status) {
        Optional<AirCompany> existingAirCompanyOptional = airCompanyRepository.findByName(airCompanyName);
        AirCompany existingAirCompany = existingAirCompanyOptional.orElseThrow(
                () -> new EntityNotFoundException("Aircompany with name" +airCompanyName +"doesn't exist")
        );

        return existingAirCompany.getFlights().stream()
                .filter(flight ->  String.valueOf(flight.getFlightStatus()).equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

}
