package com.hostel.management.system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long floorId;

    private int floorNumber;

    @ManyToOne
    @JoinColumn(name="hostel_id")
    private Hostel hostel;

}