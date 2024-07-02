package com.aluracursos.radio.principal;

import com.aluracursos.radio.modelos.Cancion;
import com.aluracursos.radio.modelos.MisFavoritos;
import com.aluracursos.radio.modelos.Podcast;

public class Principal {
    public static void main(String[] args) {
        Cancion miCancion = new Cancion();
        miCancion.setTitulo("Forever");
        miCancion.setCantante("Kiss");

        Podcast miPodcast = new Podcast();
        miPodcast.setPresentador("Gabriela Aguilar");
        miPodcast.setTitulo("Cafe.Tech");

        for (int i = 0; i < 100; i++) {
            miCancion.meGusta();
        }
        for (int i = 0; i < 2000; i++) {
            miCancion.reproduce();
        }

        for (int i = 0; i < 100; i++) {
            miPodcast.meGusta();
        }
        for (int i = 0; i < 8000; i++) {
            miPodcast.reproduce();
        }
        System.out.println("Total reproducciones: " + miCancion.getTotalDeReproducciones());
        System.out.println("Total de Me gusta: " + miCancion.getTotalDeMeGusta());

        MisFavoritos misFavoritos = new MisFavoritos();
        misFavoritos.adicione(miCancion);
        misFavoritos.adicione(miPodcast);
    }
}
