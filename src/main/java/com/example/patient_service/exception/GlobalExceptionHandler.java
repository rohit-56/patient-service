package com.example.patient_service.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      errors.put(error.getObjectName(), error.getDefaultMessage());
    });
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(EmailAlreadyExistException.class)
  public ResponseEntity<Map<String, String>> handleEmailAlreadyExistException(
      EmailAlreadyExistException e) {

    Map<String, String> errors = new HashMap<>();
    errors.put("message", "Email Already Exist");
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

}
