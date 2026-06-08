package com.example.ipljerseystore.addressrepository;

import com.example.ipljerseystore.addressdto.AddressResponseDto;
import com.example.ipljerseystore.addressentity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> findByUsersUserId(long id);

    Optional<Address> findByUsersUserIdAndIsDefaultTrue(long id);

    int countByUsersUserId(long userId);


}
