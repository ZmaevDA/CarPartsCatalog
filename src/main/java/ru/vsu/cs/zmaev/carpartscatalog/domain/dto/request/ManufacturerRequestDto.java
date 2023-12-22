package ru.vsu.cs.zmaev.carpartscatalog.domain.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.vsu.cs.zmaev.carpartscatalog.domain.enums.ProductionType;

@Data
@Schema(description = "Описание класса ManufacturerRequestDto")
public class ManufacturerRequestDto {
    @Schema(description = "Название брэнда", example = "Honda")
    private final String brandName;
    @Schema(description = "Страна производителя", example = "Япония")
    private final String country;
    @Schema(description = "Тип производимой продукции", example = "ALL", enumAsRef = true)
    private final ProductionType productionType;
}
