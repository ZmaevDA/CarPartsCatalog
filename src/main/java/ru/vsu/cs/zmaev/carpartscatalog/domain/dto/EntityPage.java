package ru.vsu.cs.zmaev.carpartscatalog.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
public class EntityPage {
    private int pageNumber;
    private int pageSize;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "id";
}
