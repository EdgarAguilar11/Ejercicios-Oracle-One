package com.pupum.modelos;

public class Compra {

    private String descripcion;
    private double costo;

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public Compra (String descripcion, double costo){
        this.descripcion = descripcion;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return this.getDescripcion() + " - $" + this.getCosto();
    }
}
