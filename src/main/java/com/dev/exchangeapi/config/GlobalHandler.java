package com.dev.exchangeapi.config;

import com.dev.exchangeapi.exceptions.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(ErrorProcessingJson.class)
    public ResponseEntity<ErrorProcessingJson> handle(ErrorProcessingJson e) {
        var exception = new ExceptionResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.name(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorProcessingQuote.class)
    public ResponseEntity<ErrorProcessingQuote> handle(ErrorProcessingQuote e) {
        var exception = new ExceptionResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.name(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorConvertingCurrency.class)
    public ResponseEntity<ErrorConvertingCurrency> handle(ErrorConvertingCurrency e) {
        var exception = new ExceptionResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.name(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorExchangeNotFound.class)
    public ResponseEntity<ErrorExchangeNotFound> handle(ErrorExchangeNotFound e) {
        var exception = new ExceptionResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND.name(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity(exception, HttpStatus.NOT_FOUND);
    }
}
