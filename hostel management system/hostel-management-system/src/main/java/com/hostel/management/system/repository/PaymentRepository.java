package com.hostel.management.system.repository;

import com.hostel.management.system.entity.Payment;
import com.hostel.management.system.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByTenant(Tenant tenant);

}