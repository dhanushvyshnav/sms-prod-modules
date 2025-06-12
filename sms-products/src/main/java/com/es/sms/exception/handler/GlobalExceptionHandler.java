package com.es.sms.exception.handler;

import com.es.sms.exception.InvalidInputException;
import com.es.sms.exception.ModuleNotFoundException;
import com.es.sms.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle InvalidProductIdException
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handleInvalidProductIdException(InvalidInputException ex) {
        // Directly return the exception message
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Handle ProductNotFoundException
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        // Directly return the exception message
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    // Handle ModuleNotFoundException
    @ExceptionHandler(ModuleNotFoundException.class)
    public ResponseEntity<String> handleModuleNotFoundException(ModuleNotFoundException ex) {
        // Directly return the exception message
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Handle Generic Exceptions (Fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        // Directly return the exception message
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}