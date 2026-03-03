package com.example.attendance.service;

import com.example.attendance.entity.Attendance;
import com.example.attendance.entity.Student;
import com.example.attendance.repository.AttendanceRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRepository repo;
    private final MailService mailService;

    public AttendanceService(AttendanceRepository r, MailService m){ this.repo = r; this.mailService = m; }

    public Attendance markAttendance(Student student, boolean present){
        var a = Attendance.builder().student(student).date(LocalDate.now()).present(present).build();
        Attendance saved = repo.save(a);
        // send email notification
        if (!student.getEmail().isBlank()) {
            mailService.sendSimpleEmail(student.getEmail(), "Attendance marked",
                    "Your attendance for " + saved.getDate() + " is " + (present ? "Present" : "Absent"));
        }
        return saved;
    }

    public List<Attendance> byStudent(Student s){ return repo.findByStudent(s); }
}
