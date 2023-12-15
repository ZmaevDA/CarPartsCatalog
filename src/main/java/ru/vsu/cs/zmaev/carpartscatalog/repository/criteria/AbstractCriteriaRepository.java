package ru.vsu.cs.zmaev.carpartscatalog.repository.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.*;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.EntityPage;
import ru.vsu.cs.zmaev.carpartscatalog.exception.CustomException;

public abstract class AbstractCriteriaRepository<T, C> implements CriteriaRepository<T, C> {

    protected final EntityManager entityManager;
    protected final CriteriaBuilder criteriaBuilder;

    protected AbstractCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    @Override
    public Page<T> findAllWithFilters(EntityPage entityPage, C searchCriteria) {
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = criteriaQuery.from(getEntityClass());
        Predicate predicate = getPredicate(searchCriteria, root);
        criteriaQuery.where(predicate);
        setOrder(entityPage, criteriaQuery, root);
        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(entityPage.getPageNumber() * entityPage.getPageSize());
        typedQuery.setMaxResults(entityPage.getPageSize());
        Pageable pageable = getPageable(entityPage);
        long count = getCount();
        return new PageImpl<>(typedQuery.getResultList(), pageable, count);
    }

    protected abstract Class<T> getEntityClass();

    protected abstract Predicate getPredicate(C searchCriteria, Root<T> root);

    protected abstract long getCount();

    private void setOrder(EntityPage entityPage, CriteriaQuery<T> criteriaQuery, Root<T> root) {
        try {
            if (entityPage.getSortDirection().equals(Sort.Direction.ASC)) {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(entityPage.getSortBy())));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(entityPage.getSortBy())));
            }
        } catch (Exception e) {
            throw new CustomException("Error setting order", e);
        }
    }

    private Pageable getPageable(EntityPage entityPage) {
        Sort sort = Sort.by(entityPage.getSortDirection(), entityPage.getSortBy());
        return PageRequest.of(entityPage.getPageNumber(), entityPage.getPageSize(), sort);
    }
}
