package com.hostel.management.system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "TENANT")
@Data
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long tenantId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "PURPOSE")
    private String purpose;

    @Column(name = "JOIN_DATE")
    private LocalDate joinDate;

    @Column(name = "STATUS")
    private String status;

    @OneToOne
    @JoinColumn(name = "BED_ID")
    private Bed bed;

}