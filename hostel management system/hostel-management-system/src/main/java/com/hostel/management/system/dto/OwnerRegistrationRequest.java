package com.hostel.management.system.dto;

import lombok.Data;
import java.util.List;

@Data
public class OwnerRegistrationRequest {

    private String ownerName;
    private String phone;
    private String email;
    private String username;
    private String password;

    private String hostelName;
    private String city;

    private List<RentRequest> rents;   // 👈 ADD THIS

    private List<FloorRequest> floors;

}