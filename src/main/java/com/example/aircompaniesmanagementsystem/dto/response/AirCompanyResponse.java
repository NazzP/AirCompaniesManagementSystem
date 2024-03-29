package com.example.aircompaniesmanagementsystem.dto.response;

import com.example.aircompaniesmanagementsystem.dto.info.AirCompanyInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirCompanyResponse {
    private String responseCode;
    private String responseMessage;
    private AirCompanyInfo accountInfo;
}
