package com.example.currencyconverter.dto;

import lombok.Data;

@Data
public class ConvertRequest {
    private String from;
    private String to;
    private double amount;
}
