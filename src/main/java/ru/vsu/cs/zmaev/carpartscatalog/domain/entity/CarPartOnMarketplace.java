package ru.vsu.cs.zmaev.carpartscatalog.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "car_part_on_marketplace")
public class CarPartOnMarketplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "marketplace_id", referencedColumnName = "id")
    private Marketplace marketplace;

    @ManyToOne
    @JoinColumn(name = "car_part_id", referencedColumnName = "id")
    private CarPart carPart;
}
