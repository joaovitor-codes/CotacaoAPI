package com.dev.exchangeapi.config;

import com.dev.exchangeapi.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ExceptionHandler({
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class
    })
    public ResponseEntity<Object> handleInvalidFormat(Exception e) {
        var exception = new ExceptionResponse(
                "Valor inválido enviado. Verifique os dados da requisição.",
                HttpStatus.BAD_REQUEST.name(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handle(MissingServletRequestParameterException e) {
        var exception = new ExceptionResponse(
                "Valor nulo encontrado. Verifique os dados da requisição: " + e.getParameterName(),
                HttpStatus.BAD_REQUEST.name(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
    }
}

