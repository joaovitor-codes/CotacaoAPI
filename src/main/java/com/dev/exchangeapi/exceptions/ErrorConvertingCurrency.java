package com.dev.exchangeapi.exceptions;

public class ErrorConvertingCurrency extends RuntimeException {
    public ErrorConvertingCurrency(String message) {
        super(message);
    }
}
