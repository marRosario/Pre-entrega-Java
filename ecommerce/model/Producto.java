package ecommerce.model;

public class Producto {
    private static int contador=1;
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;


public Producto (String nombre, double precio, int stock, String categoria){

    this.id= contador++;
    this.nombre=nombre;
    this.precio=precio;
    this.stock=stock;
    this.categoria=categoria;
}



public int getId(){return id;}
public String getNombre(){return nombre;}
public double getPrecio(){return precio;}
public int getStock(){return stock;}
public String getCategoria(){return categoria;}

public void setNombre(String nombre){this.nombre=nombre;}
public void setPrecio(double precio){this.precio=precio;}
public void setStock(int stock){this.stock=stock;}
public void setCategoria(String categoria){this.categoria=categoria;}


@Override
public String toString(){
    return "ID: " + id +
    "|" + nombre +
    "| $ "+ precio +
    "| Stock:" + stock+
    "|Categoria: " + categoria;


}}
