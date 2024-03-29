package com.example.aircompaniesmanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirCompanyRequest {
    private String name;
    private String companyType;
    private LocalDate foundedAt;
}
