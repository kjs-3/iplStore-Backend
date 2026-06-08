package com.example.ipljerseystore.productrepository;

import com.example.ipljerseystore.productdto.ProductResponseDto;
import com.example.ipljerseystore.productentity.Products;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products,Long> {
     List<Products>findByCategoryCategoryId(long id);

    List<Products> findByTeamNameIgnoreCase(String teamname);

    List<Products> findByCategoryCategoryIdAndTeamName(long categoryId, String teamname);

    Optional<Products> findByProductId(long id);
}
