package com.hostel.management.system.service;

import com.hostel.management.system.dto.VacantBedResponse;
import com.hostel.management.system.entity.Bed;
import com.hostel.management.system.repository.BedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BedService {

    private final BedRepository bedRepository;

    public List<VacantBedResponse> getVacantBeds(Integer sharingType){

        List<Bed> beds = bedRepository.findVacantBedsBySharing(sharingType);

        return beds.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private VacantBedResponse mapToResponse(Bed bed){

        VacantBedResponse res = new VacantBedResponse();

        res.setBedId(bed.getBedId());
        res.setBedNumber(bed.getBedNumber());
        res.setRoomNumber(bed.getRoom().getRoomNumber());
        res.setFloorNumber(bed.getRoom().getFloor().getFloorNumber());

        return res;
    }
}