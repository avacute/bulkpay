package io.opeleh.bulkpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.opeleh.bulkpay.model.User;

public interface UserJparepository extends JpaRepository<User, Integer>{

    // Find user from database by username
    Optional <User> findByUsername(String username);

}