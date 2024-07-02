package com.desafio;

import com.desafio.procesos.ConsumirApiLibros;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumoApiLibrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiLibrosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		ConsumirApiLibros consumirApiLibros = new ConsumirApiLibros();
		consumirApiLibros.muestraMenu();
	}
}
