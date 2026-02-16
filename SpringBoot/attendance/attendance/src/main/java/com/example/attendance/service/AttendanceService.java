package com.example.attendance.service;

import com.example.attendance.dto.AttendanceRequest;
import com.example.attendance.entity.Attendance;
import com.example.attendance.entity.User;
import com.example.attendance.repository.AttendanceRepository;
import com.example.attendance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepo;
    private final UserRepository userRepo;

    public Attendance markAttendance(AttendanceRequest req) {

        User user = userRepo.findById(req.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Attendance attendance = Attendance.builder()
                .user(user)
                .date(req.getDate())
                .status(req.getStatus())
                .remarks(req.getRemarks())
                .build();

        return attendanceRepo.save(attendance);
    }

    public List<Attendance> getUserAttendance(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return attendanceRepo.findByUserOrderByDateDesc(user);
    }
}
