package ru.vsu.cs.zmaev.carpartscatalog.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.vsu.cs.zmaev.carpartscatalog.domain.enums.ProductionType;

import java.util.List;

@Data
@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "country")
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(name = "production")
    private ProductionType productionType;

    @OneToMany(mappedBy = "manufacturer")
    private List<CarModel> carModels;

    @OneToMany(mappedBy = "manufacturer")
    private List<CarPart> carParts;
}
