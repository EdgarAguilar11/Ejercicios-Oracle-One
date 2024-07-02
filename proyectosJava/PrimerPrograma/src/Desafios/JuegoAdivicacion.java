package Desafios;

import java.util.Random;
import java.util.Scanner;

public class JuegoAdivicacion {
    public static void main(String[] args) {
        int numeroAleatorio = new Random().nextInt(100);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido al juego: Adivina el número secreto.");
        for (int i = 0; i < 5; i++) {
            System.out.println("Por favor ingresa un número:");
            int numeroUsuario = teclado.nextInt();
            if (numeroAleatorio > numeroUsuario) {
                System.out.println("El número que ingresaste es menor al número secreto, intenta nuevamente.");
            } else if (numeroAleatorio == numeroUsuario) {
                System.out.println("Felicidades, adivinaste en " + (i+1) + " intentos.");
                break;
            } else {
                System.out.println("El número que ingresaste es mayor al número secreto, intenta nuevamente");
            }
            if(i == 4){
                System.out.println("Lo siento, se terminaron los intentos.");
            }
        }
        System.out.println("El número secreto era " + numeroAleatorio);

    }

}
