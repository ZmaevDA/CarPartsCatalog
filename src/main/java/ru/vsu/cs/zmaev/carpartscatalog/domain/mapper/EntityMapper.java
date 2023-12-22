package ru.vsu.cs.zmaev.carpartscatalog.domain.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO response type parameter.
 * @param <E> - Entity type parameter.
 * @param <R> - DTO request type parameter.
 */

public interface EntityMapper<E, R, D> {
    E toEntity(R request);

    D toDto(E entity);

    D toResponse(R request);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, D dto);
}
