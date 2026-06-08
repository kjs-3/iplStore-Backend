package com.example.ipljerseystore.addressentity;

import com.example.ipljerseystore.userentity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private long addressId;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_phoneno")
    private long phoneNo;
    @Column(name="door_no")
    private String doorNo;
    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="pincode")
    private int pincode;
    @Column(name="is_default")
    private boolean isDefault=false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users users;
}
