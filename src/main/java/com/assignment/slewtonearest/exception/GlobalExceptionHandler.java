package com.assignment.slewtonearest.exception;

import com.assignment.slewtonearest.dto.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<?> handleConflict(
            RuntimeException ex, WebRequest request) {
        String message = "Internal Server Error!";
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof AppException) {
            message = ex.getMessage();
            status = ((AppException) ex).getStatusCode();
        }
        return handleExceptionInternal(ex, new Response(status.value(), message),
                new HttpHeaders(), status, request);
    }
}
