package com.example.attendance.service;

import com.example.attendance.entity.Student;
import com.example.attendance.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository r){ this.repo = r; }

    public Student create(Student s){ return repo.save(s); }
    public List<Student> all(){ return repo.findAll(); }
    public Optional<Student> get(Long id){ return repo.findById(id); }
    public void delete(Long id){ repo.deleteById(id); }
}
