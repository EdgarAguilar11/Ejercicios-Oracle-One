package com.ejemplo.utileria;

import com.ejemplo.modelos.Pelicula;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivo {
    public void guardarListaDeJson(List<Pelicula> titulos) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter escritura = new FileWriter("Titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close(); //importante cerrar
    }
}
