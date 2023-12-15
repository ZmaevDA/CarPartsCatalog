package ru.vsu.cs.zmaev.carpartscatalog.domain.dto;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class EntityPage {
    private int pageNumber;
    private int pageSize;
    private Sort.Direction sortDirection;
    private String sortBy;

    public EntityPage(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortDirection = Sort.Direction.ASC;
        this.sortBy = "id";
    }
}
