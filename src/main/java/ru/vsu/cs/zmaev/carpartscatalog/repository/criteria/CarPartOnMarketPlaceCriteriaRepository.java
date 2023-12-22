package ru.vsu.cs.zmaev.carpartscatalog.repository.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.criteria.CarPartOnMarketplaceCriteriaSearch;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.CarPart;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.CarPartOnMarketplace;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CarPartOnMarketPlaceCriteriaRepository extends AbstractCriteriaRepository<CarPartOnMarketplace, CarPartOnMarketplaceCriteriaSearch> {

    protected CarPartOnMarketPlaceCriteriaRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<CarPartOnMarketplace> getEntityClass() {
        return CarPartOnMarketplace.class;
    }

    @Override
    protected Predicate getPredicate(CarPartOnMarketplaceCriteriaSearch searchCriteria, Root<CarPartOnMarketplace> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (Objects.nonNull(searchCriteria.getOem())) {
            Join<CarPartOnMarketplace, CarPart> customJoin = root.join("carPart", JoinType.INNER);
            predicates.add(criteriaBuilder.like(customJoin.get("oem"), "%" + searchCriteria.getOem()+ "%"));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    @Override
    protected long getCount() {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<CarPartOnMarketplace> countRoot = countQuery.from(CarPartOnMarketplace.class);
        countQuery.select(criteriaBuilder.count(countRoot));
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}
