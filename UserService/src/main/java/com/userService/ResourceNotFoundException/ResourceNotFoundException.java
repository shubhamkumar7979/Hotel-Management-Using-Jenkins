package com.userService.ResourceNotFoundException;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String user, String id, long l){

        super("Resource not fount on server !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
