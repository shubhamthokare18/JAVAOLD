package com.example.currencyconverter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "conversion_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conv_seq")
    @SequenceGenerator(name = "conv_seq", sequenceName = "conv_seq", allocationSize = 1)
    private Long id;

    private String apiUser;
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double resultAmount;
    private double rate;
    private Instant createdAt = Instant.now();
}
