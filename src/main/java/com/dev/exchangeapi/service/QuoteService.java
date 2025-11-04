package com.dev.exchangeapi.service;

import com.dev.exchangeapi.dto.QuoteDetailsDto;

public interface QuoteService {
    QuoteDetailsDto seekQuote(String originCurrency, String destinationCurrency);
}
