package com.hostel.management.system.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String message){
        super(message);
    }

}