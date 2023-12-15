package ru.vsu.cs.zmaev.carpartscatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.UserCarMap;

@Repository
public interface UserCarMapRepository extends JpaRepository<UserCarMap, Long> {
}
