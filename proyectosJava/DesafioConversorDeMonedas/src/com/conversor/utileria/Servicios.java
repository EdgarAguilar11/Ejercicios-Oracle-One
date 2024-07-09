package com.conversor.utileria;

import com.conversor.modelos.PeticionExchangeRate;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Servicios {
    public PeticionExchangeRate obtenerConversiones(String codigo){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try{
            String direccion = "https://v6.exchangerate-api.com/v6/014c1f64f95013173d44c881/latest/"
                    + codigo;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return gson.fromJson(json, PeticionExchangeRate.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public double realizaConversion(double valorAConvertir, String codigoAConvertir, String codigoFinalDeConversion){
        PeticionExchangeRate peticionExchangeRate = obtenerConversiones(codigoAConvertir);
        return valorAConvertir * peticionExchangeRate.conversion_rates().get(codigoFinalDeConversion).getAsDouble();
    }

    public void imprimeResultados (double valorAConvertir, double resultadoDeConversion, String monedaInicial, String monedaFinal){
        System.out.println("El valor de " + valorAConvertir + " " + monedaInicial
                + " corresponde al valor final de " + resultadoDeConversion + " " + monedaFinal);
    }
}
