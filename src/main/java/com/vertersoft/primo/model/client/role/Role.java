package com.vertersoft.primo.model.client.role;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Role {

    @Id
    private String id;
}
