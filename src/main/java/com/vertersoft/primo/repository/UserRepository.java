package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByPhoneNumberAndPassword(String phoneNumber, String password);
}
