package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.RawMaterial;
import tezAlServer.dto.model.RawMaterialDto;

import java.util.List;

@Mapper
public interface RawMaterialMapper {
    RawMaterialDto toRawMaterialDto(RawMaterial rawMaterial);

    List<RawMaterialDto> toRawMaterialDtos(List<RawMaterial> rawMaterials);

    RawMaterial toRawMaterial(RawMaterialDto rawMaterialDto);
}
