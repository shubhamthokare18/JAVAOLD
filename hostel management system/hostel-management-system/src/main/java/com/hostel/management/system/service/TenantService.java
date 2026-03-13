package com.hostel.management.system.service;

import com.hostel.management.system.dto.TenantCheckinRequest;
import com.hostel.management.system.entity.Bed;
import com.hostel.management.system.entity.Tenant;
import com.hostel.management.system.repository.BedRepository;
import com.hostel.management.system.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;
    private final BedRepository bedRepository;

    public void checkinTenant(TenantCheckinRequest request){

        Bed bed = bedRepository.findById(request.getBedId())
                .orElseThrow(() -> new RuntimeException("Bed not found"));

        if(bed.isOccupied()){
            throw new RuntimeException("Bed already occupied");
        }

        Tenant tenant = new Tenant();

        tenant.setName(request.getName());
        tenant.setContact(request.getContact());
        tenant.setPurpose(request.getPurpose());
        tenant.setJoinDate(LocalDate.now());
        tenant.setStatus("ACTIVE");
        tenant.setBed(bed);

        tenantRepository.save(tenant);

        bed.setOccupied(true);
        bedRepository.save(bed);
    }

    public void checkoutTenant(Long tenantId){

        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        Bed bed = tenant.getBed();

        if(bed != null){
            bed.setOccupied(false);
            bedRepository.save(bed);
        }

        tenant.setStatus("INACTIVE");
        tenant.setBed(null);

        tenantRepository.save(tenant);
    }

    public List<Tenant> getActiveTenants(){
        return tenantRepository.findByStatus("ACTIVE");
    }

    public Tenant getTenantById(Long tenantId){

        return tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));
    }

    public List<Tenant> getCheckoutHistory(){
        return tenantRepository.findByStatus("INACTIVE");
    }

    public List<Tenant> searchTenant(String name, String contact){

        if(name != null){
            return tenantRepository.findByNameContainingIgnoreCase(name);
        }

        if(contact != null){
            return tenantRepository.findByContact(contact);
        }

        throw new RuntimeException("Provide name or contact to search");
    }

    public void transferBed(Long tenantId, Long newBedId){

        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        Bed newBed = bedRepository.findById(newBedId)
                .orElseThrow(() -> new RuntimeException("New bed not found"));

        if(newBed.isOccupied()){
            throw new RuntimeException("Selected bed is already occupied");
        }

        Bed oldBed = tenant.getBed();

        if(oldBed != null){
            oldBed.setOccupied(false);
            bedRepository.save(oldBed);
        }

        newBed.setOccupied(true);
        bedRepository.save(newBed);

        tenant.setBed(newBed);
        tenantRepository.save(tenant);
    }
}