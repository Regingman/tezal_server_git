package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Subcategory;
import tezAlServer.dto.model.SubcategoryDto;

import java.util.List;

@Mapper
public interface SubcategoryMapper {
    SubcategoryDto toSubcategoryDto(Subcategory subcategory);

    List<SubcategoryDto> toSubcategoryDtos(List<Subcategory> subcategories);

    Subcategory toSubcategory(SubcategoryDto subcategoryDto);
}
