package com.example.ipljerseystore.productentity;

import com.example.ipljerseystore.cartentity.Cart;
import com.example.ipljerseystore.categoryentity.Category;
import com.example.ipljerseystore.orderitemsentity.OrderItems;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private long productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_description")
    private String productDescription;
    @Column(name="product_image")
    private String productImage;
    @Column(name="product_price")
    private double productPrice;
    @Column(name="product_size")
    private String productSize;
    @Column(name="teamname")
    private String teamName;
    @Column(name="product_stock")
    private int productStock;
    @Column(name="created_at")
    LocalDateTime createdat=LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    Category category;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="products")
    List<Cart> cartItems;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="products")
    List<OrderItems> orderItems;
}
