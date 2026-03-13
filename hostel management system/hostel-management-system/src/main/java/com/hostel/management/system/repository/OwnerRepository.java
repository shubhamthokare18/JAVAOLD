package com.hostel.management.system.repository;

import com.hostel.management.system.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    // CHECK PHONE EXISTS
    @Query("SELECT COUNT(o) > 0 FROM Owner o WHERE o.phone = :phone")
    boolean existsPhone(@Param("phone") String phone);

    // CHECK EMAIL EXISTS
    @Query("SELECT COUNT(o) > 0 FROM Owner o WHERE o.email = :email")
    boolean existsEmail(@Param("email") String email);

    // FIND BY USERNAME (for password login)
    Optional<Owner> findByUsername(String username);

    // FIND BY PHONE (for OTP login)
    Optional<Owner> findByPhone(String phone);

    // FIND BY EMAIL (for OTP login)
    Optional<Owner> findByEmail(String email);

}