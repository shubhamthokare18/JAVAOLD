package com.hostel.management.system.controller;

import com.hostel.management.system.dto.VacantBedResponse;
import com.hostel.management.system.service.BedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beds")
@RequiredArgsConstructor
public class BedController {

    private final BedService bedService;

    @GetMapping("/vacant")
    public ResponseEntity<List<VacantBedResponse>> getVacantBeds(
            @RequestParam Integer sharingType){

        return ResponseEntity.ok(bedService.getVacantBeds(sharingType));
    }
}