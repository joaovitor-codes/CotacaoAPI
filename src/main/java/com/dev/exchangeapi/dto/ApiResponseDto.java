package com.dev.exchangeapi.dto;

import java.util.Map;

public record ApiResponseDto(String disclaimer, String license, Long timestamp, String base, Map<String, Double> rates){
}
