package com.poemese.poemese.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    private String message;

    public UserAlreadyExistsException() {}

    public UserAlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
