package com.example.test.exception;

public class BodyNotFoundException extends RuntimeException {
    public BodyNotFoundException(String message) {
        super(message);
    }
}
