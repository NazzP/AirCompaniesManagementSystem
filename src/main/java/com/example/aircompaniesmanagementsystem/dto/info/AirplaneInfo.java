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
public class AirplaneInfo {
    private String factorySerialNumber;
    private Long airCompanyId;
    private Long numberOfFlights;
    private double flightDistance;
    private double fuelCapacity;
    private String type;
    private LocalDateTime createdAt;
}
