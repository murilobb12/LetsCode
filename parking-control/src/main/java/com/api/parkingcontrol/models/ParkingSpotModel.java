package com.api.parkingcontrol.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String numeroVaga;

    @Column(nullable = false, unique = true, length = 7)
    private String placaCarro;

    @Column(nullable = false,  length = 70)
    private String marcaCarro;

    @Column(nullable = false,  length = 70)
    private String modeloCarro;

    @Column(nullable = false,  length = 70)
    private String corCarro;

    @Column(nullable = false)
    private LocalDateTime dataRegistro;

    @Column(nullable = false, unique = false, length = 10)
    private String parkingSpotNumber;





}
