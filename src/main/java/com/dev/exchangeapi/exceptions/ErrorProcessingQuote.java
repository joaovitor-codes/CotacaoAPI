package com.dev.exchangeapi.exceptions;

public class ErrorProcessingQuote extends RuntimeException {
    public ErrorProcessingQuote(String message) {
        super(message);
    }
}
