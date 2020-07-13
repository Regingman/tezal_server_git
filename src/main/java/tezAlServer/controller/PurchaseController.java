package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Purchase;
import tezAlServer.dto.mapper.PurchaseMapper;
import tezAlServer.dto.model.PurchaseDto;
import tezAlServer.service.PurchaseService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с закупками")
@RestController
@RequestMapping("purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private PurchaseMapper purchaseMapper;

    @ApiOperation(value = "Получения списка всех закупок")
    @GetMapping
    public ResponseEntity<List<PurchaseDto>> List(){
        return ResponseEntity.ok(purchaseMapper.toPurchaseDtos(purchaseService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<PurchaseDto> findById(@PathVariable("id")Long id){
        Optional<Purchase> purchase = purchaseService.findById(id);
        return purchase.isPresent() ?
                ResponseEntity.ok(purchaseMapper.toPurchaseDto(purchase.get())) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Создание закупки")
    @PostMapping
    public ResponseEntity<PurchaseDto> create(@RequestBody PurchaseDto  purchaseDto){
        purchaseService.save(purchaseMapper.toPurchase(purchaseDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseDto);
    }

    @ApiOperation(value = "Обновление закупки")
    @PutMapping("{id}")
    public ResponseEntity<PurchaseDto> update(@PathVariable("id") Long id,
            @RequestBody PurchaseDto purchaseDto) {
        Purchase purchase = purchaseMapper.toPurchase(purchaseDto);
        purchase.setId(id);
        purchaseService.save(purchase);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(purchaseDto);
    }

    @ApiOperation(value = "Удаление закупки")
    @DeleteMapping("{id}")
    public  ResponseEntity<Purchase> delete(@PathVariable("id") Long id){
        purchaseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
