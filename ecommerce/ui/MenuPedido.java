package ecommerce.ui;

import ecommerce.service.PedidoService;
import ecommerce.service.ProductoService;
import java.util.Scanner;

public class MenuPedido {
    private PedidoService pedidoService;
    private ProductoService productoService;
    private Scanner sc = new Scanner(System.in);

    public MenuPedido(PedidoService pedidoService, ProductoService productoService) {
        this.pedidoService = pedidoService;
        this.productoService = productoService;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("-----MENU PEDIDOS-----");
            System.out.println("1. Crear pedido");
            System.out.println("2. Listar pedidos");
            System.out.println("0. Volver al menu principal");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1 -> pedidoService.crearPedido(productoService, sc);
                case 2 -> pedidoService.listarPedidos();
                case 0 -> System.out.println("...Volver al menu principal...");
                default -> System.out.println("...Opcion invalida...");
            }
        } while (opcion != 0);
    }
}
