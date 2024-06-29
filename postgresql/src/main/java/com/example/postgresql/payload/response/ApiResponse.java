package com.example.postgresql.payload.response;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;


    //No Argument constructor
    public ApiResponse() {
    }

    //Without data constructor
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    //All Argument constructor
    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
