package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Container;
import tezAlServer.dto.mapper.ContainerMapper;
import tezAlServer.dto.model.ContainerDto;
import tezAlServer.service.ContainerService;
import tezAlServer.service.Impl.ContainerServiceImpl;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с контейнером")
@RestController
@RequestMapping("container")
public class ContainerController {
    @Autowired
    private ContainerServiceImpl containerService;
    @Autowired
    private ContainerMapper containerMapper;

    @ApiOperation(value = "Получения списка всех контейнеров")
    @GetMapping
    public ResponseEntity<List<ContainerDto>> List(){
        return ResponseEntity.ok(containerMapper.toContainerDTOs(containerService.findAll()));
    }

    @ApiOperation(value = "Получение информации о контейнере")
    @GetMapping("{id}")
    public ResponseEntity<ContainerDto> findById(@PathVariable Long id) {
        Optional<Container> container = containerService.findById(id);
        return (container.isPresent()) ?
                ResponseEntity.ok(containerMapper.toContainerDTO(container.get())) :
                ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Получения списка всех контейнеров одной категории")
    @GetMapping("{id}/all")
    public ResponseEntity<List<ContainerDto>> getAllById(@PathVariable("id") Long categoryId, @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        List<Container> containers = containerService.getAllById(categoryId, pageable);
        return  ResponseEntity.ok(containerMapper.toContainerDTOs(containers));
    }

    @ApiOperation(value = "Создание контейнера")
    @PostMapping
    public ResponseEntity<ContainerDto> create(@RequestBody ContainerDto  container){
        containerService.save(containerMapper.toContainer(container));
        return ResponseEntity.status(HttpStatus.CREATED).body(container);
    }

    @ApiOperation(value = "Обновление контейнера")
    @PutMapping("{id}")
    public ResponseEntity<ContainerDto> update(@PathVariable("id") Long id,
            @RequestBody ContainerDto containerDto) {
        Container container = containerMapper.toContainer(containerDto);
        container.setId(id);
        containerService.save(container);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(containerDto);
    }

    @ApiOperation(value = "Удаление контейнера")
    @DeleteMapping("{id}")
    public  ResponseEntity<Container> delete(@PathVariable("id") Long id){
        containerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
