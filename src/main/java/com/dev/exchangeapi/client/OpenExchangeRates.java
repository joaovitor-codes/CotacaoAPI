package com.dev.exchangeapi.client;

public interface OpenExchangeRates {
    String seekQuote(String baseCurrency, String targetCurrency);
}
