package ru.vsu.cs.zmaev.carpartscatalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.EntityPage;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.criteria.ManufacturerCriteriaSearch;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.request.ManufacturerRequestDto;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.response.ManufacturerResponseDto;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.Manufacturer;
import ru.vsu.cs.zmaev.carpartscatalog.domain.mapper.ManufacturerMapper;
import ru.vsu.cs.zmaev.carpartscatalog.exception.NoSuchEntityException;
import ru.vsu.cs.zmaev.carpartscatalog.repository.ManufacturerRepository;
import ru.vsu.cs.zmaev.carpartscatalog.repository.criteria.ManufacturerCriteriaRepository;
import ru.vsu.cs.zmaev.carpartscatalog.service.ManufacturerService;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerCriteriaRepository manufacturerCriteriaRepository;

    private final ManufacturerMapper manufacturerMapper;

    @Override
    public Page<ManufacturerResponseDto> findAllWithFilters(EntityPage entityPage, ManufacturerCriteriaSearch criteriaSearch) {
        return manufacturerCriteriaRepository
                .findAllWithFilters(entityPage, criteriaSearch)
                .map(manufacturerMapper::toDto);
    }

    @Override
    public Manufacturer findOne(Long id) {
        return manufacturerRepository.findById(id).orElseThrow(() ->
                new NoSuchEntityException(Manufacturer.class, id));
    }

    @Override
    public Manufacturer save(ManufacturerRequestDto requestDto) {
        return manufacturerRepository.save(manufacturerMapper.toEntity(requestDto));
    }

    @Override
    public Manufacturer update(Long id, ManufacturerRequestDto dto) {
        return manufacturerRepository
                .findById(id)
                .map(existingEvent -> {
                    manufacturerMapper.partialUpdate(existingEvent, dto);
                    return existingEvent;
                })
                .map(manufacturerRepository::save)
                .orElseThrow(() -> new NoSuchEntityException(Manufacturer.class, id));
    }

    @Override
    public void delete(Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() ->
                new NoSuchEntityException(Manufacturer.class, id));
        manufacturerRepository.delete(manufacturer);
    }
}
