package com.moy.appfacturas.modelo;

public class Producto {
    private int sku;
    private String nombre;
    private double precio;
    private static int ultimoSku;

    public Producto(){
        this.sku = ++ultimoSku;
    }

    public int getSku() {
        return sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return sku +
                "\t" + nombre +
                "\t" + precio;
    }
}
