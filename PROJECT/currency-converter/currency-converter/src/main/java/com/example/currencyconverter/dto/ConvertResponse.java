package com.example.currencyconverter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvertResponse {
    private String from;
    private String to;
    private double amount;
    private double rate;
    private double result;
}
