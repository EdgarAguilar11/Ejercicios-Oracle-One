package com.conversor.diccionario;

public enum Moneda {

    USD("USD", "United States Dollar", "United States"),
    ARS("ARS","Argentine Peso","Argentina"),
    BOB("BOB","Bolivian Boliviano","Bolivia"),
    BRL("BRL","Brazilian Real","Brazil"),
    CLP("CLP","Chilean Peso","Chile"),
    COP("COP","Colombian Peso","Colombia"),
    MXN("MXN", "Mexican Peso", "Mexico");


    private String codigo;
    private String nombre;
    private String pais;

    private Moneda (String codigo, String nombre, String pais){
        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }
}
