package com.hostel.management.system.repository;

import com.hostel.management.system.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}