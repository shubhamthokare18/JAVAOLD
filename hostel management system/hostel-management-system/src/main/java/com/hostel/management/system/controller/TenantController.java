package com.hostel.management.system.controller;

import com.hostel.management.system.dto.ApiResponse;
import com.hostel.management.system.dto.TenantCheckinRequest;
import com.hostel.management.system.dto.TransferBedRequest;
import com.hostel.management.system.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenants")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @PostMapping("/checkin")
    public ApiResponse checkin(@RequestBody TenantCheckinRequest request){

        tenantService.checkinTenant(request);

        return ApiResponse.builder()
                .success(true)
                .message("Tenant checked in successfully")
                .build();
    }

    @PutMapping("/checkout/{tenantId}")
    public ApiResponse checkout(@PathVariable Long tenantId){

        tenantService.checkoutTenant(tenantId);

        return ApiResponse.builder()
                .success(true)
                .message("Tenant checked out successfully")
                .build();
    }

    @GetMapping
    public ApiResponse getAllTenants(){

        return ApiResponse.builder()
                .success(true)
                .message("Active tenants list")
                .data(tenantService.getActiveTenants())
                .build();
    }

    @GetMapping("/{tenantId}")
    public ApiResponse getTenant(@PathVariable Long tenantId){

        return ApiResponse.builder()
                .success(true)
                .message("Tenant details")
                .data(tenantService.getTenantById(tenantId))
                .build();
    }

    @GetMapping("/history")
    public ApiResponse getCheckoutHistory(){

        return ApiResponse.builder()
                .success(true)
                .message("Checkout tenant history")
                .data(tenantService.getCheckoutHistory())
                .build();
    }

    @GetMapping("/search")
    public ApiResponse searchTenant(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String contact){

        return ApiResponse.builder()
                .success(true)
                .message("Tenant search result")
                .data(tenantService.searchTenant(name, contact))
                .build();
    }

    @PutMapping("/transfer-bed")
    public ApiResponse transferBed(@RequestBody TransferBedRequest request){

        tenantService.transferBed(request.getTenantId(), request.getNewBedId());

        return ApiResponse.builder()
                .success(true)
                .message("Tenant bed transferred successfully")
                .build();
    }
}