package com.example.ipljerseystore.orderrepository;

import com.example.ipljerseystore.orderdto.OrderResponseDto;
import com.example.ipljerseystore.orderentity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
   List<Orders> findByUsers_UserId(long users);

    List<Orders> findAllByOrderByOrderIdDesc();

    List<Orders> findByStatus(Orders.OrderStatus orderStatus);

    long countByStatus(Orders.OrderStatus orderStatus);
}
