package com.example.aircompaniesmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirCompanyInfo {
    private String name;
    private String companyType;
    private LocalDate foundedAt;
}
