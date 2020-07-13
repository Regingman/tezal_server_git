package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Sale;
import tezAlServer.dto.mapper.SaleMapper;
import tezAlServer.dto.model.SaleDto;
import tezAlServer.service.SaleService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с продажами")
@RestController
@RequestMapping("sale")
public class SaleController {
    @Autowired
    SaleService saleService;
    @Autowired
    SaleMapper saleMapper;

    @ApiOperation(value = "Получения списка всех продаж")
    @GetMapping
    public ResponseEntity<List<SaleDto>> List(){
        return ResponseEntity.ok(saleMapper.toSaleDtos(saleService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<SaleDto> getById(@PathVariable("id") Long id){
        Optional<Sale> sale = saleService.findById(id);
        return sale.isPresent() ?
                ResponseEntity.ok(saleMapper.toSaleDto(sale.get())) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Создание продажи")
    @PostMapping
    public ResponseEntity<SaleDto> create(@RequestBody SaleDto  saleDto){
        saleService.save(saleMapper.toSale(saleDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(saleDto);
    }

    @ApiOperation(value = "Обновление продажи")
    @PutMapping("{id}")
    public ResponseEntity<SaleDto> update(@PathVariable("id") Long id,
            @RequestBody SaleDto saleDto) {
        Sale sale = saleMapper.toSale(saleDto);
        sale.setId(id);
        saleService.save(sale);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(saleDto);
    }

    @ApiOperation(value = "Удаление продажи")
    @DeleteMapping("{id}")
    public  ResponseEntity<Sale> delete(@PathVariable("id") Long id){
        saleService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
