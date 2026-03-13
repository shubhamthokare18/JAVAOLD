package com.hostel.management.system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long roomId;

    private int roomNumber;

    private int sharingType;   // ⭐ IMPORTANT (1,2,3,4,5 sharing)

    @ManyToOne
    @JoinColumn(name="floor_id")
    private Floor floor;

}