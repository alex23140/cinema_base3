package com.kata.cinema.base.webapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalRestControllerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> globalException(Exception exception) {
        return ResponseEntity.status(400).body(exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationException(ConstraintViolationException exception) {
        return ResponseEntity.status(400).body(exception.getMessage());
    }
}
