package com.dev.exchangeapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private String error;
    private int code;
}
