package com.hostel.management.system.dto;

import lombok.Data;
import java.util.List;

@Data
public class FloorRequest {

    private int floorNumber;

    private List<RoomRequest> rooms;

}