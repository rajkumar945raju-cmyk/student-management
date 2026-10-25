package com.kiet.student.util;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(
            ResponseStatusException ex) {

        Map<String, String> error = Map.of(
                "message", ex.getReason()
        );

        return ResponseEntity
                .status(ex.getStatusCode())
                .body(error);
    }
}
