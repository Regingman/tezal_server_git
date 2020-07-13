package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.CustomerDiscount;
import tezAlServer.dto.mapper.CustomerDiscountMapper;
import tezAlServer.dto.model.CustomerDiscountDto;
import tezAlServer.service.CustomerDiscountService;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с клиентскими скидками")
@RestController
@RequestMapping("customerDiscount")
public class CustomerDiscountController {
    @Autowired
    private CustomerDiscountService customerDiscountService;
    @Autowired
    private CustomerDiscountMapper customerDiscountMapper;

    @ApiOperation(value = "Получения списка всех клиентских скидок")
    @GetMapping
    public ResponseEntity<List<CustomerDiscountDto>> List(){
        return ResponseEntity.ok(
                customerDiscountMapper.toCustomerDiscountDtos
                        (customerDiscountService.findAll()));
    }

    @ApiOperation(value = "Получение информации о контейнере")
    @GetMapping("{id}")
    public ResponseEntity<CustomerDiscountDto> findById(@PathVariable Long id) {
        Optional<CustomerDiscount> customerDiscount = customerDiscountService.findById(id);
        return (customerDiscount.isPresent()) ?
                ResponseEntity.ok(customerDiscountMapper.toCustomerDiscountDto(customerDiscount.get())) :
                ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Создание клиентской скидки")
    @PostMapping
    public ResponseEntity<CustomerDiscountDto> create(@RequestBody CustomerDiscountDto  customerDiscount){
        customerDiscountService.save(customerDiscountMapper.toCustomerDiscount(customerDiscount));
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDiscount);
    }

    @ApiOperation(value = "Обновление клиентской скидки")
    @PutMapping("{id}")
    public ResponseEntity<CustomerDiscountDto> update(@PathVariable("id") Long id,
            @RequestBody CustomerDiscountDto customerDiscountDto) {
        CustomerDiscount customerDiscount = customerDiscountMapper.toCustomerDiscount(customerDiscountDto);
        customerDiscount.setId(id);
        customerDiscountService.save(customerDiscount);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerDiscountDto);
    }

    @ApiOperation(value = "Удаление клиентской скидки")
    @DeleteMapping("{id}")
    public  ResponseEntity<CustomerDiscount> delete(@PathVariable("id") Long id){
        customerDiscountService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
