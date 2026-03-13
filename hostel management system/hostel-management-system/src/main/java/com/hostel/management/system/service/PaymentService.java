package com.hostel.management.system.service;

import com.hostel.management.system.dto.PaymentRequest;
import com.hostel.management.system.entity.Payment;
import com.hostel.management.system.entity.Tenant;
import com.hostel.management.system.repository.PaymentRepository;
import com.hostel.management.system.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final TenantRepository tenantRepository;

    public void payRent(PaymentRequest request){

        Tenant tenant = tenantRepository.findById(request.getTenantId())
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        Payment payment = new Payment();

        payment.setTenant(tenant);
        payment.setAmount(request.getAmount());
        payment.setPaymentDate(LocalDate.now());
        payment.setStatus("PAID");

        paymentRepository.save(payment);
    }

    public List<Payment> getTenantPayments(Long tenantId){

        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        return paymentRepository.findByTenant(tenant);
    }

    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

}