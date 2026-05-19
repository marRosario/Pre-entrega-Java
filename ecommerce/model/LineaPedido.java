package ecommerce.model;

public class LineaPedido {
    private Producto producto;
    private int cantidad;


    public LineaPedido(Producto producto,int cantidad){
        this.producto=producto;
        this.cantidad=cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    
    public double getSubtotal(){
        return producto.getPrecio()*cantidad;
    }
    public int getCantidad(){
        return cantidad;
    }


    @Override
    public String toString(){
        return producto.getNombre() +
        " x " + cantidad +
        " = " + getSubtotal();
    }
}
