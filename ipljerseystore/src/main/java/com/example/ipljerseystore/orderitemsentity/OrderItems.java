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
