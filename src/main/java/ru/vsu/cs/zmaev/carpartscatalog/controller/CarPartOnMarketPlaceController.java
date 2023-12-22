package ru.vsu.cs.zmaev.carpartscatalog.controller;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.EntityPage;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.criteria.CarPartOnMarketplaceCriteriaSearch;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.response.CarPartOnMarketplaceResponseDto;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.CarPartOnMarketplace;
import ru.vsu.cs.zmaev.carpartscatalog.domain.mapper.CarPartOnMarketplaceMapper;
import ru.vsu.cs.zmaev.carpartscatalog.service.CarPartOnMarketPlaceService;

@RestController
@RequestMapping("/api/car-pars-on-marketplace")
@RequiredArgsConstructor
public class CarPartOnMarketPlaceController {

    private final CarPartOnMarketPlaceService service;
    private final CarPartOnMarketplaceMapper mapper;

    @GetMapping()
    public ResponseEntity<Page<CarPartOnMarketplaceResponseDto>> findAllWithFilters(
            @RequestParam(defaultValue = "0")
            @Min(value = 0) Integer pagePosition,
            @RequestParam(defaultValue = "10")
            @Min(value = 1)
            Integer pageSize,
            @RequestParam String oem
    ) {
        Page<CarPartOnMarketplace> response = service.findAllWithFilters(
                new EntityPage(pagePosition, pageSize),
                new CarPartOnMarketplaceCriteriaSearch(oem));
        return ResponseEntity.status(HttpStatus.OK).body(response.map(mapper::toDto));
    }
}
