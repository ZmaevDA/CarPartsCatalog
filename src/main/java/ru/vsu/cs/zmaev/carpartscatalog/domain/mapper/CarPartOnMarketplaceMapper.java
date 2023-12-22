package ru.vsu.cs.zmaev.carpartscatalog.domain.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.request.CarPartOnMarketPlaceRequestDto;
import ru.vsu.cs.zmaev.carpartscatalog.domain.dto.response.CarPartOnMarketplaceResponseDto;
import ru.vsu.cs.zmaev.carpartscatalog.domain.entity.CarPartOnMarketplace;

@Mapper(componentModel = "spring")
public interface CarPartOnMarketplaceMapper extends EntityMapper<CarPartOnMarketplace, CarPartOnMarketPlaceRequestDto, CarPartOnMarketplaceResponseDto> {
    CarPartOnMarketplace toEntity(CarPartOnMarketPlaceRequestDto request);

    CarPartOnMarketplaceResponseDto toDto(CarPartOnMarketplace entity);

    CarPartOnMarketplaceResponseDto toResponse(CarPartOnMarketPlaceRequestDto request);

}
