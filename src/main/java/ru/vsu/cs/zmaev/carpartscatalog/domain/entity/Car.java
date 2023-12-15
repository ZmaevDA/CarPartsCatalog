package ru.vsu.cs.zmaev.carpartscatalog.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.vsu.cs.zmaev.carpartscatalog.domain.enums.CarType;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "car_type")
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Column(name = "release_year")
    private Instant releaseYear;

    @Lob
    @Column(name = "car_image")
    private byte[] carImage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_model_id", referencedColumnName = "id")
    private CarModel carModel;

    @OneToMany(mappedBy = "car")
    private List<CarPart> carParts;

    @OneToMany(mappedBy = "car")
    private List<UserCarMap> userCarsMap;

    @ManyToOne
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private Engine engine;

    @ManyToOne
    @JoinColumn(name = "transmission_id", referencedColumnName = "id")
    private Transmission transmission;
}
