package com.moy.appfacturas;

import com.moy.appfacturas.modelo.Cliente;
import com.moy.appfacturas.modelo.Factura;
import com.moy.appfacturas.modelo.ItemFactura;
import com.moy.appfacturas.modelo.Producto;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setRfc("asdfa45-a");
        cliente.setNombre("moy-ui");

        Scanner in  = new Scanner(System.in);
        System.out.print("Ingrese una descripción para la factura: ");
        String descripción = in.nextLine();

        Factura factura = new Factura(descripción, cliente);

        Producto producto;
        String nombre;
        double precio;
        int cantidad;

        System.out.println();

        for (int i = 0; i < 5; i++){
            producto = new Producto();
            System.out.print("Ingrese el producto " + producto.getSku() + ": ");
            nombre = in.nextLine();
            producto.setNombre(nombre);

            System.out.print("Ingrese el precio del producto: ");
            precio = in.nextDouble();
            producto.setPrecio(precio);

            System.out.print("Ingrese la cantidad: ");
            cantidad= in.nextInt();

            ItemFactura item = new ItemFactura(cantidad, producto);
            factura.addItemFactura(item);

            System.out.println("\n");
            in.nextLine();
        }
        System.out.println(factura.generarDetalle());

    }
}
