package com.pupum.principal;

import com.pupum.modelos.Compra;
import com.pupum.modelos.TarjetaDeCredito;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Compra> listaDeCompras = new ArrayList<>();
        System.out.println("### Escribe el límite de la tarjeta:");
        double montoLimite = teclado.nextDouble();
        TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito(montoLimite);

        int continuar = 1;
        while(continuar != 0){
            System.out.println("###Escriba la descripción de la compra:");
            //se agrega ya que el nextDoble() no genera el caracter de nueva linea para iniciar correctamente el nextLine()
            teclado.nextLine();
            String descripcion = teclado.nextLine();

            System.out.println("###Escriba el valor de la compra:");
            double costo = teclado.nextDouble();

            Compra compra = new Compra(descripcion, costo);

            if(tarjetaDeCredito.realizarCompra(compra)){
                System.out.println("Compra realizada!");
            }else{
                System.out.println("Saldo insuficiente!");
                break;
            }
            System.out.println("Escriba 0 para salir o 1 para continuar");
            continuar = teclado.nextInt();
        }
        System.out.println("""                        
                        ################
                        Compras realizadas                        
                        """);
        tarjetaDeCredito.getListaDeCompras().sort(Comparator.comparing(Compra::getDescripcion));
        tarjetaDeCredito.getListaDeCompras().forEach(System.out::println);
        System.out.println("""
                        \n################
                        Saldo en la tarjeta: $""" + tarjetaDeCredito.getSaldoDisponible());

    }
}
