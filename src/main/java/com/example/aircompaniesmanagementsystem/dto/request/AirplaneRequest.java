package com.example.aircompaniesmanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirplaneRequest {
    private String factorySerialNumber;
    private Long airCompanyId = null;
    private long numberOfFlights;
    private double flightDistance;
    private double fuelCapacity;
    private String type;
}
