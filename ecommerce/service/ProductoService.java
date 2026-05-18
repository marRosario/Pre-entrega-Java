package ecommerce.service;

import ecommerce.exception.StockInsuficienteException;
import ecommerce.model.Producto;
import ecommerce.exception.ProductoNoEncontradoException;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public Producto eliminarProducto(String nombre) throws ProductoNoEncontradoException {
        Producto p = buscarPorNombre(nombre);
        if (p == null) {
            throw new ProductoNoEncontradoException("No se encontró el producto  " + nombre);
        }
        productos.remove(p);
        System.out.println("Producto eliminado: " + p);
        return p;
    }

    public Producto buscarProducto(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

public double venderProducto(String nombre, int cantidad) throws StockInsuficienteException {
    Producto producto = buscarPorNombre(nombre);

    if(producto==null){
        throw new ProductoNoEncontradoException("El producto no existe:" + nombre);

    }
    if (producto.getStock() < cantidad) {
        throw new StockInsuficienteException("Stock insuficiente para " + producto.getNombre());
    }

    double totalVenta=producto.getPrecio()*cantidad;

    if(totalVenta>10000){
        double descuento=totalVenta*0.15;
        totalVenta-=descuento;
        System.out.println("Se aplico un descuento del 15%. Total con descuento: $ " +totalVenta);
    
    }
    producto.setStock(producto.getStock() - cantidad);
    return totalVenta;
}


    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos cargados.");
        } else {
            for(Producto p :productos){
                System.out.println(p);
            }
            }
        }

        public Producto buscarPorNombre(String nombre){
            return productos.stream()
            .filter(p-> p.getNombre().trim().equalsIgnoreCase(nombre.trim()))
            .findFirst()
            .orElseThrow(()->new ProductoNoEncontradoException("Producto con nombre: " + nombre + " no encontrado "));
        
    }
}



