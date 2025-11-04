package com.dev.exchangeapi.client.impl;

import com.dev.exchangeapi.client.OpenExchangeRates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class OpenExchangeRatesImpl implements OpenExchangeRates {
    @Value("${openexchangerates.key}")
    private String API_KEY;
    @Value("${openexchangerates.baseurl}")
    private String BASE_URL;

    @Override
    public String seekQuote(String baseCurrency, String targetCurrency) {
        String url =
                BASE_URL
                + "?app_id=" + API_KEY
                        + "&base=" + baseCurrency
                        + "&symbols=" + targetCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request;

        System.out.println("Conectando à URL: " + url);
        request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200){
                return response.body();
            }else{
                System.err.println("Falha na conexão. Código de status: " + response.statusCode());
                System.err.println("Resposta da API: " + response.body());
            }
        }catch (IOException | InterruptedException e){
            System.err.println("Ocorreu um erro ao fazer a requisição: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
