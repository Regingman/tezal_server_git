package tezAlServer.dto.mapper;

import org.mapstruct.Mapper;
import tezAlServer.domain.Category;
import tezAlServer.dto.model.CategoryDto;

import java.util.List;

@Mapper
public interface CategoryMapper {

        CategoryDto toCategoryDto(Category category);

        List<CategoryDto> toCategoryDtos(List<Category> categories);

        Category toCategory(CategoryDto categoryDto);
}
