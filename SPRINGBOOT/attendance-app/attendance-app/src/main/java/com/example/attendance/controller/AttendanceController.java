package com.example.attendance.controller;

import com.example.attendance.entity.Attendance;
import com.example.attendance.entity.Student;
import com.example.attendance.repository.StudentRepository;
import com.example.attendance.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    private final StudentRepository studentRepo;
    private final AttendanceService attendanceService;

    public AttendanceController(StudentRepository sr, AttendanceService as){
        this.studentRepo = sr; this.attendanceService = as;
    }

    @PostMapping("/mark/{studentId}")
    public ResponseEntity<?> mark(@PathVariable Long studentId, @RequestParam boolean present){
        var st = studentRepo.findById(studentId).orElse(null);
        if (st == null) return ResponseEntity.notFound().build();
        Attendance a = attendanceService.markAttendance(st, present);
        return ResponseEntity.ok(a);
    }
}
