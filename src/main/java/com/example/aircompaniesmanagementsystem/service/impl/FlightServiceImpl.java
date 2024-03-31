package com.example.aircompaniesmanagementsystem.service.impl;

import com.example.aircompaniesmanagementsystem.dto.info.FlightInfo;
import com.example.aircompaniesmanagementsystem.dto.request.FlightRequest;
import com.example.aircompaniesmanagementsystem.dto.response.FlightResponse;
import com.example.aircompaniesmanagementsystem.entity.AirCompany;
import com.example.aircompaniesmanagementsystem.entity.Airplane;
import com.example.aircompaniesmanagementsystem.entity.Flight;
import com.example.aircompaniesmanagementsystem.entity.Status;
import com.example.aircompaniesmanagementsystem.exception.NullEntityReferenceException;
import com.example.aircompaniesmanagementsystem.repository.AirCompanyRepository;
import com.example.aircompaniesmanagementsystem.repository.AirplaneRepository;
import com.example.aircompaniesmanagementsystem.repository.FlightRepository;
import com.example.aircompaniesmanagementsystem.service.FlightService;
import com.example.aircompaniesmanagementsystem.utils.ResponseUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    FlightRepository flightRepository;
    AirCompanyRepository airCompanyRepository;
    AirplaneRepository airplaneRepository;

    public FlightServiceImpl(FlightRepository flightRepository, AirCompanyRepository airCompanyRepository, AirplaneRepository airplaneRepository) {
        this.flightRepository = flightRepository;
        this.airCompanyRepository = airCompanyRepository;
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public FlightResponse add(FlightRequest request) {

        AirCompany existingAirCompany = airCompanyRepository.findById(request.getAirCompanyId()).orElseThrow(
                () -> new NullEntityReferenceException("AirCompany with id " + request.getAirCompanyId() + " is not found")
        );
        Airplane existingAirplane = airplaneRepository.findById(request.getAirplaneId()).orElseThrow(
                () -> new NullEntityReferenceException("Airplane with id " + request.getAirplaneId() + " is not found")
        );

        Flight newFlight = Flight.builder()
                .airCompany(existingAirCompany)
                .airplane(existingAirplane)
                .departureCountry(request.getDepartureCountry())
                .destinationCountry(request.getDestinationCountry())
                .distance(request.getDistance())
                .estimatedFlightTime(request.getEstimatedFlightTime())
                .flightStatus(Status.PENDING)
                .startedAt(null)
                .endedAt(null)
                .delayStartedAt(null)
                .build();

        flightRepository.save(newFlight);

        return FlightResponse.builder()
                .responseCode(ResponseUtils.FLIGHT_CREATION_SUCCESSFULLY_CODE)
                .responseMessage(ResponseUtils.FLIGHT_CREATION_SUCCESS_MESSAGE)
                .flightInfo(FlightInfo.builder()
                        .airCompanyId(newFlight.getAirCompany().getId())
                        .airplaneId(newFlight.getAirplane().getId())
                        .departureCountry(newFlight.getDepartureCountry())
                        .destinationCountry(newFlight.getDestinationCountry())
                        .distance(newFlight.getDistance())
                        .estimatedFlightTime(newFlight.getEstimatedFlightTime())
                        .flightStatus(String.valueOf(newFlight.getFlightStatus()))
                        .startedAt(newFlight.getStartedAt())
                        .endedAt(newFlight.getEndedAt())
                        .delayStartedAt(newFlight.getDelayStartedAt())
                        .createdAt(newFlight.getCreatedAt())
                        .build())
                .build();
    }

    @Override
    public FlightResponse changeStatus(Long flightId, String status) {
        Flight existingFlight = flightRepository.findById(flightId).orElseThrow(
                () -> new NullEntityReferenceException("Flight with id " + flightId + " is not found")
        );

        switch (status) {
            case "DELAYED" -> {
                existingFlight.setDelayStartedAt(LocalDateTime.now());
                existingFlight.setFlightStatus(Status.DELAYED);
            }
            case "ACTIVE" -> {
                existingFlight.setStartedAt(LocalDateTime.now());
                existingFlight.setFlightStatus(Status.ACTIVE);
            }
            case "COMPLETED" -> {
                existingFlight.setEndedAt(LocalDateTime.now());
                existingFlight.setFlightStatus(Status.COMPLETED);
            }
            case "PENDING" -> {
                existingFlight.setFlightStatus(Status.PENDING);
                existingFlight.setEndedAt(null);
                existingFlight.setEndedAt(null);
                existingFlight.setDelayStartedAt(null);
            }
            default -> throw new IllegalArgumentException("Unknown status: " + status);
        }

        flightRepository.save(existingFlight);

        return FlightResponse.builder()
                .responseCode(ResponseUtils.FLIGHT_STATUS_UPDATION_SUCCESSFULLY_CODE)
                .responseMessage(ResponseUtils.FLIGHT_STATUS_UPDATION_SUCCESS_MESSAGE)
                .flightInfo(FlightInfo.builder()
                        .airCompanyId(existingFlight.getAirCompany().getId())
                        .airplaneId(existingFlight.getAirplane().getId())
                        .departureCountry(existingFlight.getDepartureCountry())
                        .destinationCountry(existingFlight.getDestinationCountry())
                        .distance(existingFlight.getDistance())
                        .estimatedFlightTime(existingFlight.getEstimatedFlightTime())
                        .flightStatus(String.valueOf(existingFlight.getFlightStatus()))
                        .startedAt(existingFlight.getStartedAt())
                        .endedAt(existingFlight.getEndedAt())
                        .delayStartedAt(existingFlight.getDelayStartedAt())
                        .createdAt(existingFlight.getCreatedAt())
                        .build())
                .build();
    }


    @Override
    public List<Flight> findAllActiveFlightsStartedMoreThan24HoursAgo() {
        return flightRepository.findAllByStatus(Status.ACTIVE).stream()
                .filter(flight -> flight.getStartedAt().isAfter(LocalDateTime.now().minusDays(1)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findFlightsWithCompletedStatusAndTimeDifferenceExceeded() {
        List<Flight> completedFlights = flightRepository.findAllByStatus(Status.COMPLETED);
        return completedFlights.stream()
                .filter(flight -> flight.getEndedAt().isAfter(
                        flight.getStartedAt().plusSeconds((long) (flight.getEstimatedFlightTime() * 3600))
                ))
                .collect(Collectors.toList());
    }
}
