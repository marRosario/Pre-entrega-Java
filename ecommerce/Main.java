package ecommerce;

import ecommerce.exception.ProductoNoEncontradoException;
import ecommerce.exception.StockInsuficienteException;
import ecommerce.service.ProductoService;
import ecommerce.ui.MenuProducto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear dependencias
        ProductoService service = new ProductoService();
        Scanner sc = new Scanner(System.in);
        MenuProducto menu = new MenuProducto(sc, service);

        int opcion;
        do {
            menu.mostrarMenu();
            opcion = sc.nextInt();

            try {
                switch (opcion) {
                    case 1 -> menu.agregarProducto();
                    case 2 -> service.listarProductos();
                    case 3 -> menu.venderProducto();
                    case 4 -> menu.eliminarProducto();
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

            System.out.println(); // línea en blanco entre operaciones
        } while (opcion != 0);

        sc.close();
    }
}
