package ru.vsu.cs.zmaev.carpartscatalog.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.vsu.cs.zmaev.carpartscatalog.domain.enums.TransmissionType;

import java.util.List;

@Data
@Entity
@Table(name = "transmission_type")
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission_name")
    private TransmissionType transmissionType;

    @OneToMany(mappedBy = "transmission")
    private List<Car> cars;
}
