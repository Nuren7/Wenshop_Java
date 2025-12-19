package com.example.webshop.model;

public class OrderItem {

    private long productId;
    private int quantity;
    private double priceAtPurchase;

    // Tom konstruktor (krävs för JSON)
    public OrderItem() {
    }

    // Konstruktor
    public OrderItem(long productId, int quantity, double priceAtPurchase) {
        this.productId = productId;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
    }

    // Getters och setters

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public void setPriceAtPurchase(double priceAtPurchase) {
        this.priceAtPurchase = priceAtPurchase;
    }
}
