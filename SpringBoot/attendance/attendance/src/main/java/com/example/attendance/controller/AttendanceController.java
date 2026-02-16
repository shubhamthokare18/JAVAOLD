package com.example.attendance.controller;

import com.example.attendance.entity.Attendance;
import com.example.attendance.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceRepository attendanceRepo;

    @PostMapping
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        return attendanceRepo.save(attendance);
    }

    @GetMapping("/{userId}")
    public java.util.List<Attendance> getAttendance(@PathVariable Long userId) {
        return attendanceRepo.findByUserId(userId);
    }
}
