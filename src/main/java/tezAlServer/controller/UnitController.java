package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Unit;
import tezAlServer.dto.mapper.UnitMapper;
import tezAlServer.dto.model.UnitDto;
import tezAlServer.service.UnitService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с единицами измерения")
@RestController
@RequestMapping("unit")
public class UnitController {
    @Autowired
    private UnitService unitService;
    @Autowired
    private UnitMapper unitMapper;

    @ApiOperation(value = "Получения списка всех единиц измерения")
    @GetMapping
    public ResponseEntity<List<UnitDto>> List(){
        return ResponseEntity.ok(unitMapper.toUnitDtos(unitService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<UnitDto> getById(@PathVariable("id") Long id){
        Optional<Unit> unit = unitService.findById(id);
        return unit.isPresent() ?
                ResponseEntity.ok(unitMapper.toUnitDto(unit.get())) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Создание единицы измерения")
    @PostMapping
    public ResponseEntity<UnitDto> create(@RequestBody UnitDto  unitDto){
        unitService.save(unitMapper.toUnit(unitDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(unitDto);
    }

    @ApiOperation(value = "Обновление единицы измерения")
    @PutMapping("{id}")
    public ResponseEntity<UnitDto> update(@PathVariable("id") Long id,
            @RequestBody UnitDto unitDto) {
        Unit unit = unitMapper.toUnit(unitDto);
        unit.setId(id);
        unitService.save(unit);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(unitDto);
    }

    @ApiOperation(value = "Удаление единицы измерения")
    @DeleteMapping("{id}")
    public  ResponseEntity<Unit> delete(@PathVariable("id") Long id){
        unitService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
