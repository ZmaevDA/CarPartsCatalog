package ru.vsu.cs.zmaev.carpartscatalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.EntityPage;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.criteria.CarPartOnMarketplaceCriteriaSearch;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.request.CarPartOnMarketPlaceRequestDto;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.CarPartOnMarketplace;
import ru.vsu.cs.zmaev.carpartscatalog.domain.mapper.CarPartOnMarketplaceMapper;
import ru.vsu.cs.zmaev.carpartscatalog.repository.CarPartOnMarketplaceRepository;
import ru.vsu.cs.zmaev.carpartscatalog.repository.criteria.CarPartOnMarketPlaceCriteriaRepository;
import ru.vsu.cs.zmaev.carpartscatalog.service.CarPartOnMarketPlaceService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarPartOnMarketPlaceServiceImpl implements CarPartOnMarketPlaceService {

    private final CarPartOnMarketplaceRepository carPartOnMarketplaceRepository;
    private final CarPartOnMarketPlaceCriteriaRepository carPartOnMarketPlaceCriteriaRepository;
    private final CarPartOnMarketplaceMapper carPartOnMarketplaceMapper;

    @Override
    public Page<CarPartOnMarketplace> findAllWithFilters(EntityPage entityPage, CarPartOnMarketplaceCriteriaSearch criteriaSearch) {
        return carPartOnMarketPlaceCriteriaRepository.findAllWithFilters(entityPage, criteriaSearch);
    }

    @Override
    public Optional<CarPartOnMarketplace> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CarPartOnMarketplace> save(CarPartOnMarketPlaceRequestDto request) {
        return Optional.empty();
    }

    @Override
    public Optional<CarPartOnMarketplace> update(Long id, CarPartOnMarketPlaceRequestDto request) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) { // Пока пусто
    }
}
