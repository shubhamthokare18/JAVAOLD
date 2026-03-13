package com.hostel.management.system.service;

import com.hostel.management.system.dto.*;
import com.hostel.management.system.entity.*;
import com.hostel.management.system.repository.*;
import com.hostel.management.system.util.PhoneUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final PasswordEncoder passwordEncoder;

    private final OwnerRepository ownerRepository;
    private final HostelRepository hostelRepository;
    private final FloorRepository floorRepository;
    private final RoomRepository roomRepository;
    private final BedRepository bedRepository;
    private final RentRepository rentRepository;

    private final OtpService otpService;
    private final EmailService emailService;
    private final SmsService smsService;

    public void registerOwner(OwnerRegistrationRequest request) {

        // ================= PHONE VALIDATION =================
        if (request.getPhone() == null || request.getPhone().isBlank()) {
            throw new RuntimeException("Phone number is required");
        }

        String phone = PhoneUtil.normalize(request.getPhone());

        if (!otpService.isOtpVerified(phone)) {
            throw new RuntimeException("Phone number is not verified");
        }

        // ================= EMAIL VALIDATION =================
        if (request.getEmail() == null || request.getEmail().isBlank()) {
            throw new RuntimeException("Email is required");
        }

        String email = request.getEmail().trim();

        if (!otpService.isOtpVerified(email)) {
            throw new RuntimeException("Email is not verified");
        }

        // ================= PASSWORD VALIDATION =================
        if (request.getPassword() == null || request.getPassword().isBlank()) {
            throw new RuntimeException("Password cannot be empty");
        }

        // ================= DUPLICATE CHECK =================
        if (ownerRepository.existsPhone(phone)) {
            throw new RuntimeException("Phone already registered");
        }

        if (ownerRepository.existsEmail(email)) {
            throw new RuntimeException("Email already registered");
        }

        // ================= SAVE OWNER =================
        Owner owner = new Owner();

        owner.setOwnerName(request.getOwnerName());
        owner.setPhone(phone);
        owner.setEmail(email);
        owner.setUsername(request.getUsername());
        owner.setPassword(passwordEncoder.encode(request.getPassword()));

        ownerRepository.save(owner);

        // ================= SAVE HOSTEL =================
        Hostel hostel = new Hostel();

        hostel.setHostelName(request.getHostelName());
        hostel.setCity(request.getCity());
        hostel.setOwner(owner);

        hostelRepository.save(hostel);

        // ================= SAVE RENT STRUCTURE =================
        if (request.getRents() != null) {
            for (RentRequest rentRequest : request.getRents()) {

                Rent rent = new Rent();

                rent.setSharingType(rentRequest.getSharingType());
                rent.setAmount(rentRequest.getAmount());
                rent.setHostel(hostel);

                rentRepository.save(rent);
            }
        }

        // ================= SAVE FLOORS ROOMS BEDS =================
        if (request.getFloors() != null) {

            for (FloorRequest floorRequest : request.getFloors()) {

                Floor floor = new Floor();

                floor.setFloorNumber(floorRequest.getFloorNumber());
                floor.setHostel(hostel);

                floorRepository.save(floor);

                if (floorRequest.getRooms() != null) {

                    for (RoomRequest roomRequest : floorRequest.getRooms()) {

                        Room room = new Room();

                        room.setRoomNumber(roomRequest.getRoomNumber());
                        room.setFloor(floor);

                        // sharing type = number of beds
                        if (roomRequest.getBedNumbers() != null) {
                            room.setSharingType(roomRequest.getBedNumbers().size());
                        }

                        roomRepository.save(room);

                        if (roomRequest.getBedNumbers() != null) {

                            for (Integer bedNumber : roomRequest.getBedNumbers()) {

                                Bed bed = new Bed();

                                bed.setBedNumber(bedNumber);
                                bed.setRoom(room);
                                bed.setOccupied(false);

                                bedRepository.save(bed);
                            }
                        }
                    }
                }
            }
        }

        // ================= SEND SUCCESS EMAIL =================
        emailService.sendRegistrationSuccessEmail(
                email,
                owner.getOwnerName(),
                hostel.getHostelName()
        );

        // ================= SEND SUCCESS SMS =================
        smsService.sendRegistrationSuccessSms(
                phone,
                hostel.getHostelName()
        );
    }
}