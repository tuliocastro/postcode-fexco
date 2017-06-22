package com.fexco.postcode.base.error;

public class ApiErrorResponse {

    public int statusCode;

    public String message;

    public ApiErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
