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
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Categoryname getName() {
        return name;
    }

    public void setName(Categoryname name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

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
