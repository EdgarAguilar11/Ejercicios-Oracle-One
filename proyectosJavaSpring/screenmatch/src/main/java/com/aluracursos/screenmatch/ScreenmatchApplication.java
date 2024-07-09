package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.principal.EjemploStreams;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.muestraElMenu();

//		EjemploStreams ejemploStreams = new EjemploStreams();
//		ejemploStreams.muestraEjemplo();

//		var consumoAPI = new ConsumoAPI();
//		var json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=2e18562e");
//		System.out.println(json);
//		ConvierteDatos conversor = new ConvierteDatos();
//		var datos = conversor.obtenerDatos(json, DatosSerie.class);
//		System.out.println(datos);
//
//		json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&season=1&episode=1&apikey=2e18562e");
//		DatosEpisodio episodio = conversor.obtenerDatos(json, DatosEpisodio.class);
//		System.out.println(episodio);
//
//		List<DatosTemporadas> temporadas = new ArrayList<DatosTemporadas>();
//		for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
//			json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&season="
//					+ i
//					+ "&apikey=2e18562e");
//			var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
//			temporadas.add(datosTemporadas);
//		}
//		temporadas.forEach(System.out::println);
	}
}
