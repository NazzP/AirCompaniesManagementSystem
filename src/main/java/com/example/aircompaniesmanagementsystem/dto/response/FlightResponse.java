package com.example.aircompaniesmanagementsystem.dto.response;

import com.example.aircompaniesmanagementsystem.dto.info.FlightInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightResponse {
    private String responseCode;
    private String responseMessage;
    private FlightInfo flightInfo;
}
