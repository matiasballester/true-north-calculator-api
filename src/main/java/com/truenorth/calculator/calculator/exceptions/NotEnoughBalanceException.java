package com.truenorth.calculator.calculator.exceptions;

import org.springframework.http.HttpStatus;

public class NotEnoughBalanceException extends AppException {
    public NotEnoughBalanceException(String message, HttpStatus status) {
        super(message, status);
    }

    public NotEnoughBalanceException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }
}
