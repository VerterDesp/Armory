package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhoneNumber(String phoneNumber);

    User findByPhoneNumberAndPassword(String phoneNumber, String password);
}
