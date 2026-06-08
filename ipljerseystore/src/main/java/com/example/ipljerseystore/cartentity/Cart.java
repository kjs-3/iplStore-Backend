package com.example.ipljerseystore.cartentity;

import com.example.ipljerseystore.productentity.Products;
import com.example.ipljerseystore.userentity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cart",uniqueConstraints = {@UniqueConstraint(columnNames ={ "user_id",
        "product_id"})})
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private long cartId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Products products;
    @Column(name="quantity")
    private int quantity=1;
}
