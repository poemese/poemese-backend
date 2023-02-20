package com.poemese.poemese.controllers;

import com.poemese.poemese.exceptions.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

@ControllerAdvice(basePackages = "com.poemese.poemese.controllers")
public class ExceptionController {
    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException uae) {
        return new ResponseEntity<String>(uae.getMessage(), HttpStatus.CONFLICT);
    }
}
