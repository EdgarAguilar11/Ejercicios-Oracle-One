package com.conversor.principal;

import com.conversor.diccionario.Moneda;
import com.conversor.modelos.PeticionExchangeRate;
import com.conversor.utileria.Servicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Servicios servicios = new Servicios();
        Scanner lectura = new Scanner(System.in);

        int opcion = 1;
        double valorAConvertir = 0;
        double resultadoConversion = 0;
        while(opcion != 7){
            System.out.println("""
                    ##############################################
                    -> Sea bienvenido(a) al Conversor de Moneda <-
                    
                    1) Dolar -> Peso Argentino
                    2) Peso Argentino -> Dolar
                    3) Dolar -> Real Brasileño
                    4) Real Brasileño -> Dolar
                    5) Dolar -> Peso Colombiano
                    6) Peso Colombiano -> Dolar
                    7) Salir
                    Elija una opción válida: """);

            if (lectura.hasNext()){
                if (lectura.hasNextInt()){
                    opcion = lectura.nextInt();
                    if(opcion > 0 && opcion < 7){
                        System.out.println("Ingresa el valor que deseas convertir:");
                        valorAConvertir = lectura.nextDouble();
                    }
                    switch (opcion){
                        case 1:
                            resultadoConversion = servicios.realizaConversion(
                                    valorAConvertir,Moneda.USD.getCodigo(), Moneda.ARS.getCodigo());
                            servicios.imprimeResultados(
                                    valorAConvertir,resultadoConversion,Moneda.USD.getNombre(),Moneda.ARS.getNombre());
                            break;
                        case 2:
                            resultadoConversion = servicios.realizaConversion(
                                    valorAConvertir,Moneda.ARS.getCodigo(), Moneda.USD.getCodigo());
                            servicios.imprimeResultados(
                                    valorAConvertir,resultadoConversion,Moneda.ARS.getNombre(),Moneda.USD.getNombre());
                            break;
                        case 3:
                            resultadoConversion = servicios.realizaConversion(
                                    valorAConvertir,Moneda.USD.getCodigo(), Moneda.BRL.getCodigo());
                            servicios.imprimeResultados(
                                    valorAConvertir,resultadoConversion,Moneda.USD.getNombre(),Moneda.BRL.getNombre());
                            break;
                        case 4:
                            resultadoConversion = servicios.realizaConversion(
                                    valorAConvertir,Moneda.BRL.getCodigo(), Moneda.USD.getCodigo());
                            servicios.imprimeResultados(
                                    valorAConvertir,resultadoConversion,Moneda.BRL.getNombre(),Moneda.USD.getNombre());
                            break;
                        case 5:
                            resultadoConversion = servicios.realizaConversion(
                                    valorAConvertir,Moneda.USD.getCodigo(), Moneda.COP.getCodigo());
                            servicios.imprimeResultados(
                                    valorAConvertir,resultadoConversion,Moneda.USD.getNombre(),Moneda.COP.getNombre());
                            break;
                        case 6:
                            resultadoConversion = servicios.realizaConversion(
                                    valorAConvertir,Moneda.COP.getCodigo(), Moneda.USD.getCodigo());
                            servicios.imprimeResultados(
                                    valorAConvertir,resultadoConversion,Moneda.COP.getNombre(),Moneda.USD.getNombre());
                            break;
                        case 7:
                            System.out.println("Finalizando Programa");
                            break;
                        default:
                            System.out.println("Opción Inválida");
                            break;
                    }
                }else {
                    System.out.println("Entrada inválida, finalizando programa");
                    break;
                }
            }
        }
    }
}
