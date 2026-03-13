package com.hostel.management.system.dto;

import lombok.Data;

@Data
public class VacantBedResponse {

    private Long bedId;
    private int bedNumber;
    private int roomNumber;
    private int floorNumber;

}