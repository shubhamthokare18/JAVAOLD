package com.example.attendance.controller;

import com.example.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AttendanceService attendanceService;

    @GetMapping("/attendance")
    public ResponseEntity<?> getAttendance(Authentication auth) {
        return ResponseEntity.ok(attendanceService.getUserAttendance(auth.getName()));
    }
}
