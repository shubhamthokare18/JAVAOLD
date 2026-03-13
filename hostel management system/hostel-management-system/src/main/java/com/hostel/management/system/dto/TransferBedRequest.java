package com.hostel.management.system.dto;

import lombok.Data;

@Data
public class TransferBedRequest {

    private Long tenantId;
    private Long newBedId;

}