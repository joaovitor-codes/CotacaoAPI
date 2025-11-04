package com.dev.exchangeapi.mapper.impl;

import com.dev.exchangeapi.dto.ApiResponseDto;
import com.dev.exchangeapi.dto.QuoteDetailsDto;
import com.dev.exchangeapi.exceptions.ErrorExchangeNotFound;
import com.dev.exchangeapi.exceptions.ErrorProcessingJson;
import com.dev.exchangeapi.mapper.QuoteMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class QuoteMapperImpl implements QuoteMapper {
    private ObjectMapper objectMapper = new ObjectMapper();

    public QuoteDetailsDto processJson(String jsonString){
        try {
            ApiResponseDto apiResponse = objectMapper.readValue(jsonString, ApiResponseDto.class);

            if (apiResponse.rates() == null || apiResponse.rates().isEmpty()) {
                throw new ErrorExchangeNotFound("Nenhum dado de cambio encontrada na resposta da API");
            }

            Map.Entry<String, Double> rates = apiResponse.rates().entrySet().iterator().next();
            return new QuoteDetailsDto(rates.getKey(), BigDecimal.valueOf(rates.getValue()));
        } catch (Exception e) {
            throw new ErrorProcessingJson("Erro ao processar JSON");
        }
    }
}
