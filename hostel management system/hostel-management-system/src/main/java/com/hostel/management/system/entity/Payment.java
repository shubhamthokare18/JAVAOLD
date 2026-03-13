package com.hostel.management.system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "PAYMENT")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long paymentId;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "PAYMENT_DATE")
    private LocalDate paymentDate;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "TENANT_ID")
    private Tenant tenant;

}