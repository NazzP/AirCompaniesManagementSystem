package com.example.aircompaniesmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "aircompanies")
public class AirCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "company_type", nullable = false)
    private String companyType;
    @Column(name = "founded_at", nullable = false)
    private LocalDate FoundedAt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airCompany", cascade = CascadeType.REMOVE)
    private List<Airplane> airplanes;
}
