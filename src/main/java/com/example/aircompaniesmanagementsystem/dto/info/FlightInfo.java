package com.example.aircompaniesmanagementsystem.dto.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightInfo {
    private Long airplaneId;
    private Long airCompanyId;
    private String departureCountry;
    private String destinationCountry;
    private double distance;
    private double estimatedFlightTime;
    private String flightStatus;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime createdAt;
}
