package com.example.aircompaniesmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "aircompanies")
public class AirCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "company_type")
    private String companyType;
    @Column(name = "founded_at")
    private LocalDate foundedAt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airCompany", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Flight> flights;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airCompany", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Airplane> airplanes;
}
