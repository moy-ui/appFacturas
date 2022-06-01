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
        /*String nombre;
        double precio;
        int cantidad;*/

        System.out.println();

        for (int i = 0; i < 2; i++){
            producto = new Producto();
            System.out.print("Ingrese el producto " + producto.getSku() + ": ");
            producto.setNombre(in.nextLine());

            System.out.print("Ingrese el precio del producto: ");
            producto.setPrecio(in.nextDouble());

            System.out.print("Ingrese la cantidad: ");

            factura.addItemFactura(new ItemFactura(in.nextInt(), producto));

            System.out.println("\n");
            in.nextLine();
        }
        System.out.println(factura);

    }
}
