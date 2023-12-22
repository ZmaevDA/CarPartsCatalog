package ru.vsu.cs.zmaev.carpartscatalog.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.vsu.cs.zmaev.carpartscatalog.domain.enums.PartType;

@Data
@Entity
@Table(name = "car_part_type")
public class CarPartType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "car_part_name")
    private PartType partType;

    @ManyToOne
    @JoinColumn(name = "car_part_category_id", referencedColumnName = "id")
    private CarPartCategory carPartCategory;

    @OneToOne(mappedBy = "carPartType")
    private CarPart carPart;
}
