package ru.vsu.cs.zmaev.carpartscatalog.repository.criteria;

import org.springframework.data.domain.Page;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.EntityPage;

public interface CriteriaRepository<E, C> {

    Page<E> findAllWithFilters(EntityPage entityPage, C criteriaSearch);

}
