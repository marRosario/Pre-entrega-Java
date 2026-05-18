package ecommerce.ui;
import ecommerce.util.Validador;
import ecommerce.model.Producto;
import ecommerce.service.ProductoService;
import ecommerce.exception.StockInsuficienteException;
import java.util.Scanner;

public class MenuProducto {
    private final ProductoService service;
    private final Scanner sc; 

    public MenuProducto(Scanner sc, ProductoService service){
this.sc=sc;
this.service=service;
    }

    public void mostrarMenu() {
        
            System.out.println("\n--- MENU DE PRODUCTOS---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Vender producto");
            System.out.println("4. Eliminar producto");
            System.out.println("0. Salir ");
            System.out.print("Opcion: ");
        

        
    }

    public void agregarProducto() {
        String continuar;
        do {
            sc.nextLine(); // limpiar buffer

            System.out.println("Nombre:");
            String nombre = sc.nextLine(); 

            System.out.println("Precio:");
            double precio = sc.nextDouble();
            if (!Validador.esPrecioValido(precio)) {
                throw new IllegalArgumentException("El precio debe ser mayor a cero");
            }

            System.out.println("Stock:");
            int stock = sc.nextInt();
            if (!Validador.esStockValido(stock)) {
                throw new IllegalArgumentException("El stock no puede ser negativo");
            }

            sc.nextLine();
            System.out.println("Categoria:");
            String categoria = sc.nextLine();

            service.agregarProducto(new Producto(nombre, precio, stock, categoria));
            System.out.println(" *Producto agregado correctamente");

            System.out.println("¿Desea agregar otro producto? (s/n):");
            continuar = sc.next();
        } while (continuar.equalsIgnoreCase("s"));
    }

    public void venderProducto() throws StockInsuficienteException {
        String continuar;
        
        do{
        sc.nextLine(); // limpiar buffer
        System.out.println("Nombre del producto a vender:");
        String nombre = sc.nextLine();


        System.out.println("Cantidad a vender:");
        int cantidad = sc.nextInt();
try{
    double total=service.venderProducto(nombre,cantidad);
        Producto vendido= service.buscarPorNombre(nombre);

        System.out.println("**Venta realizada correctamente**");
        System.out.println("Se vendieron " + cantidad + " unidades del producto: " + nombre);
        System.out.println("Stock disponible despues de la venta:  " + vendido.getStock());
        System.out.println("Monto final de la venta : $"+ total);
}catch(Exception e){
    System.out.println(e.getMessage());
}
System.out.println("¿Desea vender otro producto? (s/n):");
        continuar= sc.next();
        }while(continuar.equalsIgnoreCase("s"));
    }

    public void eliminarProducto() {
        String continuar;
        do{
        
        sc.nextLine();
        System.out.println("Nombre del producto a eliminar:");
        String nombre= sc.nextLine();

        Producto eliminado = service.eliminarProducto(nombre);

        
        System.out.println("*Producto eliminado correctamente**");
        System.out.println("Se elimino el producto: " + eliminado.getNombre());
        System.out.println("Stock que tenia entes de eliminar: " + eliminado.getStock());

        System.out.println("¡Desea eliminar otro producto? (s/n):");
         continuar=sc.next();
            }while (continuar.equalsIgnoreCase("s"));
     }
}
