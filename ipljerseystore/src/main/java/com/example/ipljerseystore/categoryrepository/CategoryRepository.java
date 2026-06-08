package com.example.ipljerseystore.categoryrepository;

import com.example.ipljerseystore.categoryentity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(Category.Categoryname categoryname);

    Optional<Category> findByCategoryId(long id);


}
