package ru.vsu.cs.zmaev.carpartscatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.CarPartCategory;

@Repository
public interface CarPartCategoryRepository extends JpaRepository<CarPartCategory, Long> {

}
