package com.vertersoft.primo.repository;

import com.vertersoft.primo.model.client.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
