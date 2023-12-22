package ru.vsu.cs.zmaev.carpartscatalog.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.vsu.cs.zmaev.carpartscatalog.domain.enums.ProductionType;

@Data
@Schema(description = "Описание класса ManufacturerResponseDto")
public final class ManufacturerResponseDto {
    @Schema(description = "Id производителя", example = "1")
    private final Long id;
    @Schema(description = "Название брэнда", example = "Honda")
    private final String brandName;
    @Schema(description = "Страна производителя", example = "Япония")
    private final String country;
    @Schema(description = "Тип производимой продукции", example = "ALL", enumAsRef = true)
    private final ProductionType productionType;
}
