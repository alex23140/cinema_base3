package com.kata.cinema.base.webapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalRestControllerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity globalException(Exception exception) {
        return new ResponseEntity(exception.getStackTrace(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity constraintViolationException(ConstraintViolationException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
