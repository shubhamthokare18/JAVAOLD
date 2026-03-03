package com.example.attendance.entity;

import jakarta.persistence.*;
import jakarta.transaction.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String remarks;
}
