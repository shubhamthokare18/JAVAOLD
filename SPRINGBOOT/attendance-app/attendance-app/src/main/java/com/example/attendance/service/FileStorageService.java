package com.example.attendance.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;

@Service
public class FileStorageService {
    private final Path root;

    public FileStorageService(org.springframework.core.env.Environment env) {
        String dir = env.getProperty("app.file.upload-dir", "./uploads");
        this.root = Paths.get(dir).toAbsolutePath().normalize();
        try { Files.createDirectories(this.root); } catch (Exception e) { throw new RuntimeException(e); }
    }

    public String storeFile(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path target = root.resolve(filename);
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
            return target.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    public Path load(String filename){
        return root.resolve(filename).normalize();
    }
}
