package Desafios;

public class ConversorCelsiusFahrenheit {

    public static void main(String[] args) {
        double temperaturaCelsius = 2;
        double temperaturaEnFahrenheit = convierteCelsiusAFahrenheit(temperaturaCelsius);
        System.out.println("Grados Fahrenheit: " + temperaturaEnFahrenheit);

        System.out.println("Grados Fahrenheit en número entero: " + (int) temperaturaEnFahrenheit);
    }

    public static double convierteCelsiusAFahrenheit(double temperaturaCelsius){
        return (temperaturaCelsius * 1.8) + 32;
    }
}
