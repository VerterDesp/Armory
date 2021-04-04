package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.users.role.ERole;
import com.vertersoft.primo.model.users.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
