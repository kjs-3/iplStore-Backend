package com.example.ipljerseystore.userrepository;

import com.example.ipljerseystore.userentity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    boolean existsByUserEmail(String userEmail);


   Optional<Users >findByUserEmail(String userEmail);

    Optional<Users> findByUserId(long userId);

    long countByRole(Users.Role role);
}
