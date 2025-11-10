package com.dev.exchangeapi.service.impl;

import com.dev.exchangeapi.client.OpenExchangeRates;
import com.dev.exchangeapi.dto.QuoteDetailsDto;
import com.dev.exchangeapi.mapper.QuoteMapper;
import com.dev.exchangeapi.service.QuoteService;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {
    private final OpenExchangeRates openExchangeRates;
    private final QuoteMapper mapper;

    public QuoteServiceImpl(OpenExchangeRates openExchangeRates, QuoteMapper mapper) {
        this.openExchangeRates = openExchangeRates;
        this.mapper = mapper;
    }

    @Override
    public QuoteDetailsDto seekQuote(String originCurrency, String destinationCurrency){
        return mapper.processJson(openExchangeRates.seekQuote(originCurrency, destinationCurrency));
    }
}
