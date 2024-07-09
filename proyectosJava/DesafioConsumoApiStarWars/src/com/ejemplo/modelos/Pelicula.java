package com.ejemplo.modelos;

public class Pelicula {
    private String nombre;
    private String fechaDeLanzamiento;
    private String reseña;

    public Pelicula(PeliculaSwapi peliculaSwapi){
        this.nombre = peliculaSwapi.title();
        this.fechaDeLanzamiento = peliculaSwapi.release_date();
        this.reseña = peliculaSwapi.opening_crawl();
    }

    @Override
    public String toString() {
        return "(Nombre: " + this.nombre
                + ", Fecha de lanzamiento: "+ this.fechaDeLanzamiento
                + ", Reseña: " + this.fechaDeLanzamiento + ")";
    }
}
