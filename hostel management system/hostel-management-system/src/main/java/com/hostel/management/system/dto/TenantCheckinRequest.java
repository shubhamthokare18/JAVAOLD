package com.hostel.management.system.dto;

import lombok.Data;

@Data
public class TenantCheckinRequest {

    private String name;

    private String contact;

    private String purpose;

    private Long bedId;

}