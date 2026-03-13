package com.hostel.management.system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long hostelId;

    private String hostelName;

    private String city;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

}