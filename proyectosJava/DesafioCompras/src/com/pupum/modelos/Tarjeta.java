package com.pupum.modelos;

import java.util.ArrayList;
import java.util.List;

public class Tarjeta {
    private double montoLimite;
    private double saldoDisponible;
    private List<Compra> listaDeCompras;

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }

    public double getMontoLimite() {
        return montoLimite;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public Tarjeta(double montoLimite){
        this.montoLimite = montoLimite;
        this.saldoDisponible = montoLimite;
        this.listaDeCompras = new ArrayList<>();
    }

    public boolean realizarCompra(Compra compra){
        if(this.getSaldoDisponible() >= compra.getCosto()){
            listaDeCompras.add(compra);
            this.saldoDisponible -= compra.getCosto();
            return true;
        }
        return false;
    }
}
