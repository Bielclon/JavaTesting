/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.shopgestion;

/**
 *
 * @author ADMIN
 */
public class Product {

    private int id;
    private String name;
    private double publicPrice;
    private double wholesalerPrice;
    private boolean available;
    private int stock;
    private static int totalProducts = 0;

    public Product(String name, double wholesalerPrice, int stock) {
        this.id = ++totalProducts; // Incrementa y asigna un ID único
        this.name = name;
        this.wholesalerPrice = wholesalerPrice;
        this.publicPrice = wholesalerPrice * 2; // Calcula el precio público
        this.stock = stock;
        this.available = stock > 0; // Disponible si hay stock
    }
    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPublicPrice() {
        return publicPrice;
    }

    public double getWholesalerPrice() {
        return wholesalerPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getStock() {
        return stock;
    }

    public static int getTotalProducts() {
        return totalProducts;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setWholesalerPrice(double wholesalerPrice) {
        this.wholesalerPrice = wholesalerPrice;
        this.publicPrice = wholesalerPrice * 2; // Actualizar precio público
    }

    public void setStock(int stock) {
        this.stock = stock;
        this.available = stock > 0; // Actualizar disponibilidad
    }
    public static double expire(double publicPrice){
        publicPrice = publicPrice * 0.60;
        
        return publicPrice;
    }
}


