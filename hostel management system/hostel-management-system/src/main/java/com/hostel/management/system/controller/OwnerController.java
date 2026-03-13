package com.hostel.management.system.controller;

import com.hostel.management.system.dto.OwnerRegistrationRequest;
import com.hostel.management.system.dto.ApiResponse;
import com.hostel.management.system.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    /*
     Register owner with hostel structure
    */

    @PostMapping("/register")
    public ApiResponse registerOwner(@RequestBody OwnerRegistrationRequest request){

        ownerService.registerOwner(request);

        return ApiResponse.builder()
                .success(true)
                .message("Owner registered successfully")
                .build();
    }

}