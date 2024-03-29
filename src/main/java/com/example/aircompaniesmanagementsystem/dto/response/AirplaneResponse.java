package com.example.aircompaniesmanagementsystem.dto.response;

import com.example.aircompaniesmanagementsystem.dto.info.AirplaneInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirplaneResponse {
    private String responseCode;
    private String responseMessage;
    private AirplaneInfo airplaneInfo;
}
