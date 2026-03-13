package com.hostel.management.system.dto;

import lombok.Data;
import java.util.List;

@Data
public class RoomRequest {

    private int roomNumber;

    private List<Integer> bedNumbers;

}