package com.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id") Long id,
        @JsonAlias("title") String titulo,
        @JsonAlias("subjects") ArrayList<String> temas,
        @JsonAlias("authors") ArrayList<DatosPersona>  autores,
        @JsonAlias("languages") ArrayList<String> lenguajes,
        @JsonAlias("download_count") Long numeroDescargas
) {
}
