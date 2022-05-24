package com.moy.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private static int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] itemFacturas;
    private int indiceItems;
    public static final int MAX_ITEMS = 10;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.itemFacturas = new ItemFactura[MAX_ITEMS];
        folio++;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItemFacturas() {
        return itemFacturas;
    }

    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.itemFacturas[indiceItems++] = item;
        }
    }


    public double calcularTotal() {
        double total = 0;
        for (ItemFactura item : this.itemFacturas) {
            if (item == null) {
                continue;
            }
            total += item.calcularImporte();
        }

        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t RFC: ")
                .append(this.cliente.getRfc())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");

        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n");

        sb.append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (ItemFactura item:
             this.itemFacturas) {
            if(item == null){
                continue;
            }
            sb.append(item.getProducto().getSku())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());
        return sb.toString();

    }
}
