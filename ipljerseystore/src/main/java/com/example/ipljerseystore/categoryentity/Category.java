package com.example.ipljerseystore.categoryentity;

import com.example.ipljerseystore.productentity.Products;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="category_id")
    private long categoryId;
    @Enumerated(EnumType.STRING)
    @Column(name="category_name")
    private Categoryname name;
    @Column(name="category_description")
    private String description;
    @Column(name="image_url")
    private String imageUrl;
    public enum Categoryname{
        jerseys,cap
    }
    @OneToMany(mappedBy="category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Products> products;
}
