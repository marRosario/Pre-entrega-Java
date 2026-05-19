package ecommerce;

import ecommerce.exception.ProductoNoEncontradoException;
import ecommerce.exception.StockInsuficienteException;
import ecommerce.service.ProductoService;
import ecommerce.service.PedidoService;
import ecommerce.ui.MenuProducto;
import java.util.Scanner;

public class Main {
    public static void main(String[] argumentos) {
        // Crear dependencias
        ProductoService productoService = new ProductoService();
        PedidoService pedidoService = new PedidoService();
        Scanner sc = new Scanner(System.in);

        MenuProducto menuProducto = new MenuProducto(sc, productoService);
       
        int opcion;
        do {
            System.out.println("-----MENU PRINCIPAL-----");
            System.out.println("1. Menu productos");
            System.out.println("2. Listar productos");
            System.out.println("3. Vender producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Crear pedido");
            System.out.println("6. Listar pedidos");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 
            try {
                switch (opcion) {
                    case 1 -> menuProducto.agregarProducto();
                    case 2 -> productoService.listarProductos();
                    case 3 -> menuProducto.venderProducto();
                    case 4 -> menuProducto.eliminarProducto();
                    case 5 -> pedidoService.crearPedido(productoService, sc);
                    case 6 -> pedidoService.listarPedidos();
                    case 0 -> System.out.println("...Salir del menú...");
                    default -> System.out.println("Opción inválida...");
                }
            } catch (ProductoNoEncontradoException e) {
                System.out.println("Producto no existente: " + e.getMessage());
            } catch (StockInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Dato inválido: " + e.getMessage());
            }

            System.out.println(); 
        } while (opcion != 0);

        sc.close();
    }
}
