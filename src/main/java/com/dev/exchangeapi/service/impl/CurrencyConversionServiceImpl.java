package com.dev.exchangeapi.service.impl;

import com.dev.exchangeapi.exceptions.ErrorConvertingCurrency;
import com.dev.exchangeapi.exceptions.ErrorExchangeNotFound;
import com.dev.exchangeapi.service.CurrencyConversionService;
import com.dev.exchangeapi.service.QuoteService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    private final QuoteService quoteService;

    public CurrencyConversionServiceImpl(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    public BigDecimal convert(
            @NotBlank String originCurrency, @NotBlank String destinationCurrency, BigDecimal amount){
        if(amount.equals(BigDecimal.ZERO) || amount.compareTo(BigDecimal.ZERO) < 0){
            throw new ErrorConvertingCurrency("O valor para conversão deve ser maior que zero.");
        }

        if (destinationCurrency.isBlank() || originCurrency.isBlank()) {
            throw new ErrorExchangeNotFound("As moedas de origem e destino não podem ser nulas.");
        }

        try{
            return quoteService.seekQuote(originCurrency, destinationCurrency).rates().multiply(amount);
        }catch(ErrorExchangeNotFound e){
            throw new ErrorConvertingCurrency("Error ao converter " + originCurrency + " para " + destinationCurrency + ": " + e.getMessage());
        }
    }
}
