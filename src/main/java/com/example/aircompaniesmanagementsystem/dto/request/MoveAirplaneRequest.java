package com.example.aircompaniesmanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MoveAirplaneRequest {
    private Long airCompanyId;
    private Long airPlaneId;
}
