package com.vertersoft.primo.model.guns.handgun;

import com.vertersoft.primo.model.guns.handgun.enums.HandgunType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Handgun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private HandgunType handgunType;

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

    @NotNull
    private String serialNumber;

    @NotEmpty
    private String caliber;

    private String capacity;

    private String country;

    @Lob
    private String description;
}
