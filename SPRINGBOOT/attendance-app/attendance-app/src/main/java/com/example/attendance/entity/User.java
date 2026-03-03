package com.example.attendance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @SequenceGenerator(name = "seq1", allocationSize = 50, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role; // ROLE_USER, ROLE_ADMIN
}
