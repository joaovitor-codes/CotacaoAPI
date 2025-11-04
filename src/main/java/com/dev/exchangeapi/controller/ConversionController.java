package com.dev.exchangeapi.controller;

import com.dev.exchangeapi.service.CurrencyConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/conversion")
public class ConversionController {
    private final CurrencyConversionService currencyConversionService;

    public ConversionController(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping()
    public ResponseEntity<BigDecimal> convertCurrency(@RequestParam("from") String originCurrency, @RequestParam("to") String destinationCurrency, @RequestParam("amount") BigDecimal amount) {
        BigDecimal convertedAmount = currencyConversionService.convert(originCurrency, destinationCurrency, amount);
        return ResponseEntity.ok(convertedAmount);
    }
}
