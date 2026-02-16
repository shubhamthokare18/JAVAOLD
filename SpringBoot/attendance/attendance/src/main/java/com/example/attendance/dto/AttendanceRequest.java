package com.example.attendance.dto;

import jakarta.transaction.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceRequest {
    private Long userId;
    private LocalDate date;
    private Status status;
    private String remarks;
}
