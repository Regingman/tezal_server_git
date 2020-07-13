package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Supplier;
import tezAlServer.dto.mapper.SupplierMapper;
import tezAlServer.dto.model.SupplierDto;
import tezAlServer.service.SupplierService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с поставщиками")
@RestController
@RequestMapping("supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private SupplierMapper supplierMapper;

    @ApiOperation(value = "Получения списка всех поставщиков")
    @GetMapping
    public ResponseEntity<List<SupplierDto>> List(){
        return ResponseEntity.ok(supplierMapper.toSupplierDtos(supplierService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<SupplierDto> getById(@PathVariable("id") Long id){
        Optional<Supplier> supplier = supplierService.findById(id);
        return supplier.isPresent() ?
                ResponseEntity.ok(supplierMapper.toSupplierDto(supplier.get())) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Создание поставщика")
    @PostMapping
    public ResponseEntity<SupplierDto> create(@RequestBody SupplierDto  supplierDto){
        supplierService.save(supplierMapper.toSupplier(supplierDto));
        return  ResponseEntity.status(HttpStatus.CREATED).body(supplierDto);
    }

    @ApiOperation(value = "Обновление поставщика")
    @PutMapping("{id}")
    public ResponseEntity<SupplierDto> update(@PathVariable("id") Long id,
            @RequestBody SupplierDto supplierDto) {
        Supplier supplier = supplierMapper.toSupplier(supplierDto);
        supplier.setId(id);
        supplierService.save(supplier);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(supplierDto);
    }

    @ApiOperation(value = "Удаление поставщика")
    @DeleteMapping("{id}")
    public  ResponseEntity<Supplier> delete(@PathVariable("id") Long id){
        supplierService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
