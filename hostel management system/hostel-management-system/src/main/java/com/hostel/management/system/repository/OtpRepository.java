package com.hostel.management.system.repository;

import com.hostel.management.system.entity.OtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OtpRepository extends JpaRepository<OtpVerification, Long> {

    /*
     Fetch latest OTP for identifier (Oracle 11g compatible)
    */
    @Query(value =
            "SELECT * FROM (SELECT * FROM OTP_VERIFICATION WHERE IDENTIFIER = :identifier ORDER BY OTP_ID DESC) WHERE ROWNUM = 1",
            nativeQuery = true)
    OtpVerification findLatestOtp(@Param("identifier") String identifier);

}