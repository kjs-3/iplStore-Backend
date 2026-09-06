package com.example.ipljerseystore.orderitemsentity;

import com.example.ipljerseystore.orderentity.Orders;
import com.example.ipljerseystore.productentity.Products;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="order_items")
public class OrderItems {
    public long getOrderitemsId() {
        return orderitemsId;
    }

    public void setOrderitemsId(long orderitemsId) {
        this.orderitemsId = orderitemsId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_items")
    private long orderitemsId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Orders orders;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Products products;
    @Column(name="quantity")
    private int quantity;
    @Column(name="price")
    private double price;
}
