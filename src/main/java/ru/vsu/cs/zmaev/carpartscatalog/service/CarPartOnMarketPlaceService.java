package ru.vsu.cs.zmaev.carpartscatalog.service;

import org.springframework.data.domain.Page;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.EntityPage;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.criteria.CarPartOnMarketplaceCriteriaSearch;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.request.CarPartOnMarketPlaceRequestDto;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.CarPartOnMarketplace;

import java.util.Optional;

public interface CarPartOnMarketPlaceService extends BaseService<CarPartOnMarketplace, CarPartOnMarketPlaceRequestDto, CarPartOnMarketplaceCriteriaSearch> {
    @Override
    Page<CarPartOnMarketplace> findAllWithFilters(EntityPage entityPage, CarPartOnMarketplaceCriteriaSearch criteriaSearch);

    @Override
    Optional<CarPartOnMarketplace> findOne(Long id);

    @Override
    Optional<CarPartOnMarketplace> save(CarPartOnMarketPlaceRequestDto request);

    @Override
    Optional<CarPartOnMarketplace> update(Long id, CarPartOnMarketPlaceRequestDto request);

    @Override
    void delete(Long id);
}
