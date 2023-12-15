package ru.vsu.cs.zmaev.carpartscatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.Engine;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {
}
