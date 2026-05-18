package ecommerce.util;

public class Validador {
    public static boolean esPrecioValido(double precio){
        return precio > 0;
    }

public static boolean esStockValido(int stock){
    return stock >=0;
}
}
