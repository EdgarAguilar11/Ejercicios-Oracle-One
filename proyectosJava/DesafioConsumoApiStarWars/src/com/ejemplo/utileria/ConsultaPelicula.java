package com.ejemplo.utileria;

import com.ejemplo.modelos.Pelicula;
import com.ejemplo.modelos.PeliculaSwapi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {
    public Pelicula buscaPelicula (int idPelicula){
        Gson gson = new Gson();
        String direccion = "https://swapi.py4e.com/api/films/"
                + idPelicula
                + "/";
        //se recomienda mejor la clase encoder
        gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            PeliculaSwapi peliculaSwapi = gson.fromJson(json, PeliculaSwapi.class);

            System.out.println(peliculaSwapi);

            Pelicula pelicula = new Pelicula(peliculaSwapi);
            System.out.println("Título ya convertido -> " + pelicula);

            return pelicula;
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa pelicula");
        }
    }
}
