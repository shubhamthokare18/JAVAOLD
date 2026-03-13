package com.hostel.management.system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long rentId;

    private Integer sharingType;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    private Hostel hostel;

}