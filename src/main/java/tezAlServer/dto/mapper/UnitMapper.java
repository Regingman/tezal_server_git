package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Unit;
import tezAlServer.dto.model.UnitDto;

import java.util.List;

@Mapper
public interface UnitMapper {
    UnitDto toUnitDto(Unit unit);

    List<UnitDto> toUnitDtos(List<Unit> units);

    Unit toUnit(UnitDto unitDto);
}
