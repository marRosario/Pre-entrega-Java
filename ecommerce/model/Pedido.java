    
package ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void agregarLinea(Producto producto, int cantidad) {
        lineas.add(new LineaPedido(producto, cantidad));
        producto.setStock(producto.getStock() - cantidad); // descontar stock
    }

    // 👇 Método que faltaba
    public double getTotal() {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total += linea.getSubtotal();
        }
        return total;
    }

    public void mostrarPedido() {
        System.out.println("Pedido # " + id);
        for (LineaPedido linea : lineas) {
            System.out.println("Producto: " + linea.getProducto().getNombre() +
                               " | Cantidad: " + linea.getCantidad() +
                               " | Subtotal: $" + linea.getSubtotal());
        }
        System.out.println("Total del pedido: $" + getTotal());
    }
}






