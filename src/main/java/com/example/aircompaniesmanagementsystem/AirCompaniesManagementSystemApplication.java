package com.example.aircompaniesmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AirCompaniesManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirCompaniesManagementSystemApplication.class, args);
    }

}
