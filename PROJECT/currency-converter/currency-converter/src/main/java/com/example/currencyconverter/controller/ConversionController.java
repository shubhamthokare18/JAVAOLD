package com.example.currencyconverter.controller;

import com.example.currencyconverter.dto.ConvertRequest;
import com.example.currencyconverter.dto.ConvertResponse;
import com.example.currencyconverter.entity.ConversionRecord;
import com.example.currencyconverter.repository.ConversionRecordRepository;
import com.example.currencyconverter.service.ConversionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService service;
    private final ConversionRecordRepository repo;

    @PostMapping("/convert")
    public ConvertResponse convert(@RequestBody ConvertRequest req, HttpServletRequest request) {
        String user = (String) request.getAttribute("apiUser");
        return service.convert(req, user);
    }

    @GetMapping("/history")
    public List<ConversionRecord> history(HttpServletRequest request) {
        String user = (String) request.getAttribute("apiUser");
        return repo.findByApiUserOrderByCreatedAtDesc(user);
    }
}
