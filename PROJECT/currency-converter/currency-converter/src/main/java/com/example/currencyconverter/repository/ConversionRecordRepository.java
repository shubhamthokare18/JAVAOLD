package com.example.currencyconverter.repository;

import com.example.currencyconverter.entity.ConversionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversionRecordRepository extends JpaRepository<ConversionRecord, Long> {
    List<ConversionRecord> findByApiUserOrderByCreatedAtDesc(String user);
}
