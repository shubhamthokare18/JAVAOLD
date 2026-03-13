package com.hostel.management.system.util;

public class PhoneUtil {

    public static String normalize(String phone) {

        if(phone == null) return null;

        phone = phone.replaceAll("[^0-9]", "");

        if(phone.startsWith("91") && phone.length()==12){
            phone = phone.substring(2);
        }

        return phone;
    }
}