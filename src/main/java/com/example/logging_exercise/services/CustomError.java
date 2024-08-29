package com.example.logging_exercise.services;

public class CustomError extends RuntimeException {
    public CustomError(String message) {
        super(message);
    }
}