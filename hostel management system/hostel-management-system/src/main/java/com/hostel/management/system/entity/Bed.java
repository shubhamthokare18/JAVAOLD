package com.hostel.management.system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bedId;

    private int bedNumber;

    private boolean occupied;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

}