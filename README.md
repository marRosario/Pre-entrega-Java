# 🛒 Proyecto TechLab - Gestión de Productos

Este proyecto en **Java** simula la gestión de productos y ventas para un sistema de comercio electrónico.  
Incluye operaciones básicas de inventario y manejo de excepciones personalizadas.

---

## ✨ Funcionalidades principales

- [Registrar productos] con nombre, precio y stock.
- [Listar productos]
- [Eliminar productos] del inventario con detalles de stock mostrados en la consola.
- [Vender productos] y actualizar el stock.
- Aplicar un **descuento del 15%** si la venta supera los $10.000.
- Manejo de excepciones personalizadas:
  - `ProductoNoEncontradoException`
  - `StockInsuficienteException`

---

## 📂 Estructura del proyecto

TECHLAB/
 ├── ecommerce/
 │    ├── exception/ → Excepciones personalizadas
 │    │    ├── ProductoNoEncontradoException.java
 │    │    └── StockInsuficienteException.java
 │    ├── model/ 
 │    │    └── Producto.java
 │    ├── service/ → Lógica de negocio
 │    │    └── ProductoService.java
 │    ├── ui/ → Interfaz de consola
 │    │    └── MenuProducto.java
 │    └── util/ → Utilidades
 │         └── Validador.java
 ├── Main.java → Punto de entrada del programa
 ├── .gitignore
 └── README.md

## 🧪 Cómo probar el funcionamiento

1. Ejecutar el programa con **Run Java** 
2. En el menú, seleccionar la opción **Agregar producto**.
3. Ingresar productos con precios variados (por ejemplo, $5.000, $12.000, $20.000).
4. Luego, usar la opción **Vender producto**:
   - Si el total de la venta supera los **$10.000**, se aplicará automáticamente un **descuento del 15%**.
   - En la consola se mostrará el **monto final** y el **stock actualizado**.

💡 *Para observar la lógica del descuento*, asegurate de agregar productos cuyo precio multiplicado por la cantidad vendida supere los $10.000.


## 🚀 Cómo ejecutar

### Opción 1: Desde Visual Studio Code 

1. Abrir el archivo `Main.java` en el editor.
2. Arriba a la derecha, hacer clic en el botón **Run Java** (flecha  ▶).
3. El programa se compilará y ejecutará automáticamente.
4. La salida aparecerá en la consola integrada de VS Code.


