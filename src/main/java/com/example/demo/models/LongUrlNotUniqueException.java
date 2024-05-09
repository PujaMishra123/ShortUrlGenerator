package com.example.demo.models;

public class LongUrlNotUniqueException extends RuntimeException {
    public LongUrlNotUniqueException(String message) {
        super(message);
    }
}
