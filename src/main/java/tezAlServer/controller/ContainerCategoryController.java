package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.ContainerCategory;
import tezAlServer.dto.AllContainersByCategory;
import tezAlServer.dto.mapper.ContainerCategoryMapper;
import tezAlServer.dto.model.ContainerCategoryDto;
import tezAlServer.repo.ContainersRepo;
import tezAlServer.service.ContainerCategoryService;
import tezAlServer.service.ContainerService;
import tezAlServer.service.Impl.ContainerServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с товарами контейнера")
@RestController
@RequestMapping("containerCategory")
public class ContainerCategoryController {
    @Autowired
    private ContainerCategoryService containerCategoryService;
    @Autowired
    private ContainerCategoryMapper containerCategoryMapper;
    @Autowired
    private ContainersRepo containersRepo;

    @ApiOperation(value = "Получения списка всех категорий контейнеров ")
    @GetMapping
    public ResponseEntity<List<AllContainersByCategory>> List(){
        List<ContainerCategory> allContainerCategory = new ArrayList<>();
        List<AllContainersByCategory> allContainersByCategories = new ArrayList<>();
        allContainerCategory = containerCategoryService.findAll();
        for(int i = 0;i<allContainerCategory.size();i++){
            allContainersByCategories.add(AllContainersByCategory.fromUser(
                    containersRepo.getContainerByContainerCategoryId(allContainerCategory.get(i).getId()),
                    allContainerCategory.get(i)));
        }
        return ResponseEntity.ok(allContainersByCategories);
    }

    @ApiOperation(value = "Получение информации о контейнере")
    @GetMapping("{id}")
    public ResponseEntity<ContainerCategoryDto> findById(@PathVariable Long id) {
        Optional<ContainerCategory> container = containerCategoryService.findById(id);
        return (container.isPresent()) ?
                ResponseEntity.ok(containerCategoryMapper.toContainerCategoryDto(container.get())) :
                ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Создание списка контейнера")
    @PostMapping
    public ResponseEntity<ContainerCategoryDto> create(@RequestBody ContainerCategoryDto containerCategoryDto){
        containerCategoryService.save(containerCategoryMapper.toContainerCategory(containerCategoryDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(containerCategoryDto);
    }

    @ApiOperation(value = "Обновление списка контейнера")
    @PutMapping("{id}")
    public ResponseEntity<ContainerCategoryDto> update(@PathVariable("id") Long id,
            @RequestBody ContainerCategoryDto containerCategoryDto) {
        ContainerCategory containerCategory = containerCategoryMapper.toContainerCategory(containerCategoryDto);
        containerCategory.setId(id);
        containerCategoryService.save(containerCategory);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(containerCategoryDto);
    }

    @ApiOperation(value = "Удаление списка контейнера")
    @DeleteMapping("{id}")
    public  ResponseEntity<ContainerCategory> delete(@PathVariable("id") Long id){
        containerCategoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
