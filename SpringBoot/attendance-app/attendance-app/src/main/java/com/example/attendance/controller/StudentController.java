package com.example.attendance.controller;

import com.example.attendance.entity.Student;
import com.example.attendance.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService s){ this.service = s; }

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student s){
        return ResponseEntity.ok(service.create(s));
    }

    @GetMapping
    public ResponseEntity<List<Student>> all(){ return ResponseEntity.ok(service.all()); }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id){
        return service.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){ service.delete(id); return ResponseEntity.ok().build();}
}
