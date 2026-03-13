package com.hostel.management.system.controller;

import com.hostel.management.system.dto.ApiResponse;
import com.hostel.management.system.dto.PaymentRequest;
import com.hostel.management.system.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/pay")
    public ApiResponse payRent(@RequestBody PaymentRequest request){

        paymentService.payRent(request);

        return ApiResponse.builder()
                .success(true)
                .message("Payment successful")
                .build();
    }

    @GetMapping("/tenant/{tenantId}")
    public ApiResponse tenantPaymentHistory(@PathVariable Long tenantId){

        return ApiResponse.builder()
                .success(true)
                .message("Tenant payment history")
                .data(paymentService.getTenantPayments(tenantId))
                .build();
    }

    @GetMapping
    public ApiResponse allPayments(){

        return ApiResponse.builder()
                .success(true)
                .message("All payments")
                .data(paymentService.getAllPayments())
                .build();
    }

}