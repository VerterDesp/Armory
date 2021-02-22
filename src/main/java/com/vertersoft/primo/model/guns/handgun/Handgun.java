package com.vertersoft.primo.model.guns.handgun;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vertersoft.primo.model.guns.handgun.enums.HandgunType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Handgun {

    public Handgun() {
        cratedAt = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private HandgunType handgunType;

    @Column(updatable = false)
    @Setter(AccessLevel.NONE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime cratedAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime modifiedAt;

    @Lob
    @ToString.Exclude
    private Byte[] photo;

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

    @Lob
    private String description;
}
