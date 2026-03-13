package com.hostel.management.system.repository;

import com.hostel.management.system.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent,Long> {
}