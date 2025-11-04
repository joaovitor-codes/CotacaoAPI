package com.dev.exchangeapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record QuoteDetailsDto(String name, BigDecimal rates) {
}
