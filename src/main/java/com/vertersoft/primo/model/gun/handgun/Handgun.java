package com.vertersoft.primo.model.gun.handgun;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vertersoft.primo.model.gun.handgun.enums.HandgunType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Handgun {

    public Handgun() {
        cratedAt = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private HandgunType handgunType;

    @Column(updatable = false)
    @Setter(AccessLevel.NONE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime cratedAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime modifiedAt;

    @ToString.Exclude
    private String photo;

    @PositiveOrZero
    private Float price;

    @PositiveOrZero
    private Integer leftInStock;

    private String warranty;

    private String color;

    @Positive
    private Float weight;

    @Positive
    private Float totalLength;

    @Positive
    private Float barrelLength;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotEmpty
    private String caliber;

    private String capacity;

    private String country;

    private String description;
}
