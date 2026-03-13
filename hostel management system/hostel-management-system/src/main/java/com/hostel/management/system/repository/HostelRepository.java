package com.hostel.management.system.repository;

import com.hostel.management.system.entity.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelRepository extends JpaRepository<Hostel,Long> {
}