package com.assignment.slewtonearest.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    private HttpStatus statusCode;

    public AppException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

}
