package com.example.aircompaniesmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "airplanes")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "factory_serial_number", nullable = false)
    private Long factorySerialNumber;

    @ManyToOne
    @JoinColumn(name = "aircompany_id")
    private AirCompany airCompany;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "airplane", cascade = CascadeType.REMOVE)
    private List<Flight> flights;

    @Column(name = "number_of_flights", nullable = false)
    private Long numberOfFlights;

    @Column(name = "flight_distance", nullable = false)
    private double flightDistance;

    @Column(name = "fuel_capacity", nullable = false)
    private double fuelCapacity;

    @Column(name = "type", nullable = false)
    private String type;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
