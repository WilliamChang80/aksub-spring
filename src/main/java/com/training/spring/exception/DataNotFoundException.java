package com.training.spring.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
