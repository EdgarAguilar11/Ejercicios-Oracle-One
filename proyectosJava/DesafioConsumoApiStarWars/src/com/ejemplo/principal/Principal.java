package com.ejemplo.principal;

import com.ejemplo.modelos.Pelicula;
import com.ejemplo.modelos.PeliculaSwapi;
import com.ejemplo.utileria.ConsultaPelicula;
import com.ejemplo.utileria.GeneradorDeArchivo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.tools.jconsole.JConsoleContext;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
        List<Pelicula> titulos = new ArrayList<>();
        Gson gson = null;
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        ConsultaPelicula consultaPelicula = new ConsultaPelicula();
        GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo();

        try {
            while (true) {
                System.out.println("Escriba el número de la película:");

                var busqueda = lectura.nextLine();

                if (busqueda.equalsIgnoreCase("salir")) {
                    break;
                }
                titulos.add(consultaPelicula.buscaPelicula(Integer.parseInt(busqueda)));
            }

            System.out.println(titulos);
            generadorDeArchivo.guardarListaDeJson(titulos);
            System.out.println("Finalizando la aplicación");
        } catch (NumberFormatException e) {
            System.out.println("Número no encontrado " + e.getMessage());
        } catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación");
        }
    }
}
