package com.example.attendance.repository;

import com.example.attendance.entity.Attendance;
import com.example.attendance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByUserOrderByDateDesc(User user);
}
