package com.example.aircompaniesmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flight_status")
    @Enumerated(EnumType.STRING)
    private Status flightStatus;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name = "aircompany_id")
    private AirCompany airCompany;

    @Column(name = "departure_country", nullable = false)
    private String departureCountry;

    @Column(name = "destination_country", nullable = false)
    private String destinationCountry;

    @Column(name = "distance", nullable = false)
    private double distance;

    @Column(name = "estimated_flight_time", nullable = false)
    private double estimatedFlightTime;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @Column(name = "delay_started_at")
    private LocalDateTime delayStartedAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime CreatedAt;
}
