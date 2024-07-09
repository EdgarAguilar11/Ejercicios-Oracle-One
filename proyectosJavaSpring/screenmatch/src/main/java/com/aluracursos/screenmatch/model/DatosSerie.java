package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) //ignora los campos no mapeados
public record DatosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalDeTemporadas,
        @JsonAlias("imdbRating") String evaluacion
//        @JsonProperty("") otra opcion que permite no solo leer el campo clave (deserializa) como JsonAlias
//        sino tambien establecer la clave de salida cuando se convierta el objeto a json (se serialize)
        ) {

}
