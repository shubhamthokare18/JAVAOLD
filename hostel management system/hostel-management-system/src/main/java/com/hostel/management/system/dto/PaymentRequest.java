package com.hostel.management.system.dto;

import lombok.Data;

@Data
public class PaymentRequest {

    private Long tenantId;

    private double amount;

}