package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.ContainerCategory;
import tezAlServer.dto.model.ContainerCategoryDto;

import java.util.List;

@Mapper
public interface ContainerCategoryMapper {

        ContainerCategoryDto toContainerCategoryDto(ContainerCategory containerCategory);

        List<ContainerCategoryDto> toContainerCategoryDtos(List<ContainerCategory> containerCategories);

        ContainerCategory toContainerCategory(ContainerCategoryDto containerCategoryDto);
}
