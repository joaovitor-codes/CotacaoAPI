package com.dev.exchangeapi.service;

import java.math.BigDecimal;

public interface CurrencyConversionService {
    BigDecimal convert(String originCurrency, String destinationCurrency, BigDecimal amount);
}
