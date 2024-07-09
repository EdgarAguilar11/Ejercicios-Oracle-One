package com.desafio.procesos;

import com.desafio.model.DatosBiblioteca;
import com.desafio.model.DatosLibro;
import com.desafio.service.ConsumoAPI;
import com.desafio.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsumirApiLibros {
    private Scanner lectura = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String URL_BUSCAR_LIBRO = "?search=";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu(){
        var json = consumoAPI.obtenerDatos(URL_BASE);
//        System.out.println(json);
        var datos = conversor.obtenerDatos(json, DatosBiblioteca.class);

        //Top diez libros mas descargados
        datos.listaDeLibros().stream()
                .sorted(Comparator.comparing(DatosLibro::numeroDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Buscar libro por nombre

        System.out.println("Por favor, ingresa el nombre el archivo que deseas buscar:");
        var busqueda = lectura.nextLine();

        //Busqueda de libro en los registros de la API
//        json = consumoAPI.obtenerDatos(URL_BASE
//                + URL_BUSCAR_LIBRO
//                + busqueda.replace(" ", "%20"));
//        datos = conversor.obtenerDatos(json, DatosBiblioteca.class);

        //Busqueda de libro en la consulta de 32 libros hecha
        Optional<DatosLibro> libroBuscado = datos.listaDeLibros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(busqueda.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println("Libro encontrado");
            System.out.println("Los datos son: " + libroBuscado.get());
        } else {
            System.out.println("Libro no encontrado");
        }

        DoubleSummaryStatistics est = datos.listaDeLibros().stream()
                .filter(l -> l.numeroDescargas() > 0)
                .collect(Collectors.summarizingDouble(DatosLibro::numeroDescargas));

        System.out.println("Media de las descargas: " + est.getAverage());
        System.out.println("Numero mayor de descargas: " + est.getMax());
        System.out.println("Numero menor de descargar: " + est.getMin());
        System.out.println("Libros analizados: " + est.getCount());

    }
}
