package com.example.devpulse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice // Tells Spring: "Listen for errors in ALL controllers"
public class GlobalExceptionHandler {
    // 1. Handle Validation Errors (e.g., Blank Title)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Extract the specific field errors (e.g., "title": "must not be blank")
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // 2. Handle "Not Found" Errors (e.g., Task ID 999)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeErrors(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
