package ru.vsu.cs.zmaev.carpartscatalog.service;

import org.springframework.data.domain.Page;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.EntityPage;

import java.util.Optional;

public interface BaseService<E, R, C> {
    Page<E> findAllWithFilters(EntityPage entityPage, C abstractCriteriaSearch);

    Optional<E> findOne(Long id);

    Optional<E> save(R request);
    Optional<E> update(Long id, R request);

    void delete(Long id);
}
