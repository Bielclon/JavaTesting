/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopgestion;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Shop {

    private double cash;             // Dinero en la caja, comienza con 100.00
    private Product[] inventory;     // Inventario de productos, máximo 10
    private Sale[] sales;            // Registro de ventas, máximo 10
    private int inventoryCount;      // Número actual de productos en el inventario
    private int salesCount;          // Número actual de ventas registradas

    // Constructor
    public Shop() {
        this.cash = 100.00;                  // Dinero inicial en la caja
        this.inventory = new Product[10];   // Máximo 10 productos en el inventario
        this.sales = new Sale[10];          // Máximo 10 ventas registradas
        this.inventoryCount = 0;
        this.salesCount = 0;
    }
    // Getters

    public double getCash() {
        return cash;
    }

    public Product[] getInventory() {
        return inventory;
    }

    public Sale[] getSales() {
        return sales;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public int getSalesCount() {
        return salesCount;
    }

    // Setters
    public void setCash(double cash) {
        this.cash = cash;
    }

    public void setInventory(Product[] inventory) {
        this.inventory = inventory;
        this.inventoryCount = inventory.length;
    }

    public void setSales(Sale[] sales) {
        this.sales = sales;
        this.salesCount = sales.length;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public boolean addProductToInventory(Product product) {
        if (inventoryCount >= inventory.length) {
            System.out.println("El inventario está lleno. No se pueden añadir más productos.");
            return false;
        }
        inventory[inventoryCount] = product; // Añadir el producto al inventario
        inventoryCount++; // Incrementar el contador del inventario
        System.out.println("Producto anadido al inventario: " + product.getName());
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Cargando inventario inicial...");
        Shop shop = new Shop();

        shop.addProductToInventory(new Product("Manzana", 10.00, 10));
        shop.addProductToInventory(new Product("Pera", 20.00, 20));
        shop.addProductToInventory(new Product("Hamburgesa", 30.00, 30));
        shop.addProductToInventory(new Product("Fresa", 5.00, 20));

        Scanner sc = new Scanner(System.in);
        System.out.println("Saludos a la tienda!");
        boolean exit = false;

        while (!exit) {
            // Mostrar el menú principal
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Contar caja");
            System.out.println("2. Anadir producto");
            System.out.println("3. Anadir stock");
            System.out.println("4. Marcar caduca proximamente");
            System.out.println("5. Ver inventario");
            System.out.println("6. Venta");
            System.out.println("7. Ver ventas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            int option = sc.nextInt();
            sc.nextLine(); // Consumir la línea restante

            switch (option) {
                case 1:
                    // Opción para contar caja
                    contarCaja(shop);
                    break;

                case 2:
                    addPrInv(shop, sc);
                    // Opción para añadir producto
                    break;

                case 3:
                    // Opción para añadir stock
                    addStock(shop, sc);
                    break;

                case 4:
                    // Opción para marcar caduca próximamente
                    break;

                case 5:
                    // Opción para ver inventario
                    break;

                case 6:
                    // Opción para gestionar una venta
                    break;

                case 7:
                    // Opción para ver ventas
                    break;

                case 0:
                    // Salir del programa
                    System.out.println("Saliendo del programa. Gracias!");
                    exit = true;
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }

    }

    public Product findProductByName(String name) {
        for (int i = 0; i < inventoryCount; i++) {
            if (inventory[i].getName().equalsIgnoreCase(name)) { // Comparar ignorando mayúsculas
                return inventory[i]; // Devolver el producto encontrado
            }
        }
        System.out.println("Producto no encontrado: " + name);
        return null; // Retorna null si no se encuentra
    }

    public static void contarCaja(Shop shop) {

        System.out.println("The shop cash is: " + shop.getCash());

    }

    public static void addPrInv(Shop shop, Scanner sc) {

        System.out.println("Nombre del producto");
        String name = sc.nextLine();
        System.out.println("Precio del producto");
        double cost = sc.nextDouble();
        System.out.println("Cantidad del producto");
        int stock = sc.nextInt();

        sc.nextLine(); //Cleaan

        shop.addProductToInventory(new Product(name, cost, stock));

    }

    public static void addStock(Shop shop, Scanner sc) {
        System.out.println("Escriba el nombre del producto a aumentar el stock:");
        String name = sc.nextLine();

        Product product = shop.findProductByName(name);

        if (product != null) {
            System.out.print("Ingrese la cantidad de stock a añadir: ");
            int additionalStock = sc.nextInt();
            product.setStock(product.getStock() + additionalStock); // Incrementar el stock
            System.out.println("Stock actualizado: " + product.getName()
                    + ", Nuevo stock: " + product.getStock());
        } else {
            System.out.println("Producto no encontrado.");
        }

    }

}
