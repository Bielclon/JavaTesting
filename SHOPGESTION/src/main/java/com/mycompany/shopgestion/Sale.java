/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shopgestion;

/**
 *
 * @author ADMIN
 */
import java.util.ArrayList;

public class Sale {

    private String client;          // Nombre del cliente
    private Product[] products;     // Array de productos vendidos, máximo 10
    private double amount;          // Total de la compra
    private int productCount;       // Número actual de productos en la venta

    // Constructor
    public Sale(String client) {
        this.client = client;
        this.products = new Product[10]; // Máximo 10 productos
        this.amount = 0.0;
        this.productCount = 0;
    }
// Getters
    public String getClient() {
        return client;
    }

    public Product[] getProducts() {
        return products;
    }

    public double getAmount() {
        return amount;
    }

    public int getProductCount() {
        return productCount;
    }

    // Setters
    public void setClient(String client) {
        this.client = client;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
