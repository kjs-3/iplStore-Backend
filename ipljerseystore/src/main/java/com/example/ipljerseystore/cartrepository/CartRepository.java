package com.example.ipljerseystore.cartrepository;

import com.example.ipljerseystore.cartdto.CartResponseDto;
import com.example.ipljerseystore.cartentity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByCartId(Long id);

    Optional<Cart> findByUsersUserIdAndProductsProductId(long userId, long productId);

    List<Cart> findByUsersUserId(long id);
    @Modifying
    @Query(value = "DELETE FROM cart WHERE user_id = :userId", nativeQuery = true)
    int deleteByUsersUserIdNative(@Param("userId") long userId);

    String deleteByUsersUserId(long id);
}
