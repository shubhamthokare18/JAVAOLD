package com.hostel.management.system.entity;

import jakarta.persistence.*;
import lombok.Data;

/*
 Owner of the hostel
*/

@Entity
@Data
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ownerId;

    private String ownerName;

    private String phone;

    private String email;

    private String username;

    private String password;

}