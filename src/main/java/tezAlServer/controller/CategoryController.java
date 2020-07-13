package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Category;
import tezAlServer.dto.mapper.CategoryMapper;
import tezAlServer.dto.model.CategoryDto;
import tezAlServer.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с категориями товаров")
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryMapper categoryMapper;

    @ApiOperation(value = "Получения списка всех категорий товаров")
    @GetMapping
    public ResponseEntity<List<CategoryDto>> List(){
        return ResponseEntity.ok(categoryMapper.toCategoryDtos(categoryService.findAll()));
    }

    @ApiOperation(value = "Get category by id")
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return (category.isPresent()) ?
                ResponseEntity.ok(categoryMapper.toCategoryDto(category.get())) :
                ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Создание категории товара")
    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto  categoryDto){
        categoryService.save(categoryMapper.toCategory(categoryDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDto);
    }

    @ApiOperation(value = "Обновление категории товара")
    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable("id") Long id,
            @RequestBody CategoryDto categoryDto) {
        Category category = categoryMapper.toCategory(categoryDto);
        category.setId(id);
        categoryService.save(category);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryDto);
    }

    @ApiOperation(value = "Удаление категории товара")
    @DeleteMapping("{id}")
    public  ResponseEntity<Category> delete(@PathVariable("id") Long id){
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

}
