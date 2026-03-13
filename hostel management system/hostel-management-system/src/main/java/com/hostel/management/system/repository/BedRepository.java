package com.hostel.management.system.repository;

import com.hostel.management.system.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BedRepository extends JpaRepository<Bed,Long> {

    @Query("""
            SELECT b FROM Bed b
            WHERE b.occupied = false
            AND b.room.sharingType = :sharingType
            """)
    List<Bed> findVacantBedsBySharing(@Param("sharingType") Integer sharingType);

}