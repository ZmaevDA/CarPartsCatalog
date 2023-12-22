package ru.vsu.cs.zmaev.carpartscatalog.service;

import org.springframework.data.domain.Page;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.EntityPage;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.criteria.ManufacturerCriteriaSearch;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.request.ManufacturerRequestDto;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.response.ManufacturerResponseDto;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.Manufacturer;

public interface ManufacturerService {

    Page<ManufacturerResponseDto> findAllWithFilters(EntityPage entityPage, ManufacturerCriteriaSearch criteriaSearch);

    Manufacturer findOne(Long id);

    Manufacturer save(ManufacturerRequestDto requestDto);

    Manufacturer update(Long id, ManufacturerRequestDto requestDto);

    void delete(Long id);
}
