package com.example.aircompaniesmanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightRequest {
    private Long airplaneId;
    private Long airCompanyId;
    private String departureCountry;
    private String destinationCountry;
    private double distance;
    private double estimatedFlightTime;
    private Optional<LocalDateTime> startedAt;
    private Optional<LocalDateTime> endedAt;
    private Optional<LocalDateTime> delayStartedAt;
}
