package com.example.attendance.controller;

import com.example.attendance.entity.Student;
import com.example.attendance.repository.StudentRepository;
import com.example.attendance.service.FileStorageService;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileStorageService storage;
    private final StudentRepository studentRepo;
    public FileController(FileStorageService s, StudentRepository r){ this.storage = s; this.studentRepo = r; }

    @PostMapping("/upload/{studentId}")
    public ResponseEntity<?> upload(@PathVariable Long studentId, @RequestParam("file") MultipartFile file) {
        var student = studentRepo.findById(studentId).orElse(null);
        if (student == null) return ResponseEntity.notFound().build();
        String path = storage.storeFile(file);
        student.setDocumentPath(path);
        studentRepo.save(student);
        return ResponseEntity.ok("Uploaded");
    }

    @GetMapping("/download/{studentId}")
    public ResponseEntity<Resource> download(@PathVariable Long studentId) throws Exception {
        var student = studentRepo.findById(studentId).orElse(null);
        if (student == null || student.getDocumentPath() == null) return ResponseEntity.notFound().build();
        Path p = Path.of(student.getDocumentPath());
        Resource r = new UrlResource(p.toUri());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + p.getFileName().toString() + "\"")
                .body(r);
    }
}
