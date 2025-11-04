package com.dev.exchangeapi.service.impl;

import com.dev.exchangeapi.exceptions.ErrorConvertingCurrency;
import com.dev.exchangeapi.service.CurrencyConversionService;
import com.dev.exchangeapi.service.QuoteService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    private final QuoteService quoteService;

    public CurrencyConversionServiceImpl(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    public BigDecimal convert(String originCurrency, String destinationCurrency, BigDecimal amount){
        if(amount.equals(BigDecimal.ZERO) || amount.compareTo(BigDecimal.ZERO) < 0){
            throw new ErrorConvertingCurrency("O valor para conversão deve ser maior que zero.");
        }

        try{
            return quoteService.seekQuote(originCurrency, destinationCurrency).rates().multiply(amount);
        }catch(Exception e){
            throw new ErrorConvertingCurrency("Error ao converter" + originCurrency + " para " + destinationCurrency + ": " + e.getMessage());
        }
    }
}
