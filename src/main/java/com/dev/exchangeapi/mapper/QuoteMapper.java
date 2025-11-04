package com.dev.exchangeapi.mapper;

import com.dev.exchangeapi.dto.QuoteDetailsDto;

public interface QuoteMapper {
    QuoteDetailsDto processJson(String jsonString);
}
