package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Subcategory;
import tezAlServer.dto.mapper.SubcategoryMapper;
import tezAlServer.dto.model.SubcategoryDto;
import tezAlServer.service.SubcategoryService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с подкатегориями товаров")
@RestController
@RequestMapping("subcategory")
public class SubcategoryController {
    @Autowired
    SubcategoryService subcategoryService;
    @Autowired
    SubcategoryMapper subcategoryMapper;

    @ApiOperation(value = "Получения списка всех подкатегорий товаров")
    @GetMapping
    public ResponseEntity<List<SubcategoryDto>> List(){
        return ResponseEntity.ok(subcategoryMapper.toSubcategoryDtos(subcategoryService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<SubcategoryDto> getById(@PathVariable("id") Long id){
        Optional<Subcategory> subcategory = subcategoryService.findById(id);
        return subcategory.isPresent() ?
                ResponseEntity.ok(subcategoryMapper.toSubcategoryDto(subcategory.get())) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Создание подкатегории товаров")
    @PostMapping
    public ResponseEntity<SubcategoryDto> create(@RequestBody SubcategoryDto  subcategoryDto){
        subcategoryService.save(subcategoryMapper.toSubcategory(subcategoryDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(subcategoryDto);
    }

    @ApiOperation(value = "Обновление подкатегории товара")
    @PutMapping("{id}")
    public ResponseEntity<SubcategoryDto> update(@PathVariable("id") Long id,
            @RequestBody SubcategoryDto subcategoryDto) {
        Subcategory subcategory = subcategoryMapper.toSubcategory(subcategoryDto);
        subcategory.setId(id);
        subcategoryService.save(subcategory);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(subcategoryDto);
    }

    @ApiOperation(value = "Удаление подкатегории товара")
    @DeleteMapping("{id}")
    public  ResponseEntity<Subcategory> delete(@PathVariable("id") Long id){
        subcategoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
