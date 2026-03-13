package com.hostel.management.system.repository;

import com.hostel.management.system.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

    List<Tenant> findByStatus(String status);

    List<Tenant> findByNameContainingIgnoreCase(String name);

    List<Tenant> findByContact(String contact);
}