package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.RawMaterial;
import tezAlServer.dto.mapper.RawMaterialMapper;
import tezAlServer.dto.model.RawMaterialDto;
import tezAlServer.service.RawMaterialService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с сырьем")
@RestController
@RequestMapping("rawMaterial")
public class RawMaterialController {
    @Autowired
    private RawMaterialService rawMaterialService;
    @Autowired
    private RawMaterialMapper rawMaterialMapper;

    @ApiOperation(value = "Получения списка всего сырья")
    @GetMapping
    public ResponseEntity<List<RawMaterialDto>> List(){
        return ResponseEntity.ok(rawMaterialMapper.toRawMaterialDtos(rawMaterialService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<RawMaterialDto> getById(@PathVariable("id") Long id){
        Optional<RawMaterial> rawMaterial = rawMaterialService.findById(id);
        return rawMaterial.isPresent() ?
                ResponseEntity.ok(rawMaterialMapper.toRawMaterialDto(rawMaterial.get())) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Создание сырья")
    @PostMapping
    public ResponseEntity<RawMaterialDto> create(@RequestBody RawMaterialDto  rawMaterialDto){
        rawMaterialService.save(rawMaterialMapper.toRawMaterial(rawMaterialDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(rawMaterialDto);
    }

    @ApiOperation(value = "Обновление сырья")
    @PutMapping("{id}")
    public ResponseEntity<RawMaterialDto> update(@PathVariable("id") Long id,
            @RequestBody RawMaterialDto rawMaterialDto) {
        RawMaterial rawMaterial = rawMaterialMapper.toRawMaterial(rawMaterialDto);
        rawMaterial.setId(id);
        rawMaterialService.save(rawMaterial);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(rawMaterialDto);
    }

    @ApiOperation(value = "Удаление сырья")
    @DeleteMapping("{id}")
    public  ResponseEntity<RawMaterial> delete(@PathVariable("id") Long id){
        rawMaterialService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
