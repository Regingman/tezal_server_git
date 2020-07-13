package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Discount;
import tezAlServer.dto.mapper.DiscountMapper;
import tezAlServer.dto.model.DiscountDto;
import tezAlServer.service.DiscountService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию со скидками")
@RestController
@RequestMapping("discount")
public class DiscountController {
    @Autowired
    private DiscountService discountService;
    @Autowired
    private DiscountMapper discountMapper;

    @ApiOperation(value = "Получения списка всех скидок")
    @GetMapping
    public ResponseEntity<List<DiscountDto>> List(){
        return ResponseEntity.ok(discountMapper.toDiscountDtos(discountService.findAll()));
    }

    @ApiOperation(value = "Получение информации о discount")
    @GetMapping("{id}")
    public ResponseEntity<DiscountDto> findById(@PathVariable Long id) {
        Optional<Discount> container = discountService.findById(id);
        return (container.isPresent()) ?
                ResponseEntity.ok(discountMapper.toDiscountDto(container.get())) :
                ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Создание скидки")
    @PostMapping
    public ResponseEntity<DiscountDto> create(@RequestBody DiscountDto  discount){
        discountService.save(discountMapper.toDiscount(discount));
        return ResponseEntity.status(HttpStatus.CREATED).body(discount);
    }

    @ApiOperation(value = "Обновление скидки")
    @PutMapping("{id}")
    public ResponseEntity<DiscountDto> update(@PathVariable("id") Long id,
            @RequestBody DiscountDto discountDto) {
        Discount discount = discountMapper.toDiscount(discountDto);
        discount.setId(id);
        discountService.save(discount);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(discountDto);
    }

    @ApiOperation(value = "Удаление скидки")
    @DeleteMapping("{id}")
    public  ResponseEntity<Discount> delete(@PathVariable("id") Long id){
        discountService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
