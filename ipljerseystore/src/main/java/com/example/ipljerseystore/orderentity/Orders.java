package com.example.ipljerseystore.orderentity;

import com.example.ipljerseystore.addressentity.Address;
import com.example.ipljerseystore.orderitemsentity.OrderItems;
import com.example.ipljerseystore.userentity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.model.relational.ColumnOrderingStrategy;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class Orders {
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderItems> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private long orderId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="address_id")
    private Address address;
    @Column(name="total_pay")
    private double totalAmount;
    @Column(name="order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status=OrderStatus.PENDING;
    public enum OrderStatus{
        PENDING,CONFIRMED,SHIPPED,DELIVERED,CANCELLED
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy="orders",cascade = CascadeType.ALL)
    List<OrderItems> orderItemsList;
}
