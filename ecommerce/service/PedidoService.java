
package ecommerce.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


import ecommerce.model.Pedido;
import ecommerce.model.Producto;

public class PedidoService {
    private List<Pedido> pedidos = new ArrayList<>();
    private int contadorPedidos = 1;

    public void crearPedido(ProductoService productoService, Scanner sc) {
        Pedido pedido = new Pedido(contadorPedidos++);

        System.out.println("Ingrese nombre del producto:");
        String nombre = sc.nextLine().trim();

        Producto p = productoService.buscarPorNombre(nombre);

        if (p != null) {
            System.out.println("Ingrese cantidad:");
            int cantidad = sc.nextInt();
            sc.nextLine(); 

            if (cantidad <= p.getStock()) {
                pedido.agregarLinea(p, cantidad);
                pedidos.add(pedido);
                System.out.println("Pedido creado exitosamente");
                pedido.mostrarPedido();
            } else {
                System.out.println("No hay stock suficiente para el producto: " + p.getNombre());
            }
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados");
        } else {
            for (Pedido pedido : pedidos) {
                pedido.mostrarPedido();
                System.out.println("------------------------");
            }
        }
    }






}
