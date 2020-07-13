package tezAlServer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tezAlServer.domain.Order;
import tezAlServer.domain.Sale;
import tezAlServer.dto.mapper.OrderMapper;
import tezAlServer.dto.mapper.SaleMapper;
import tezAlServer.dto.model.OrderDto;
import tezAlServer.dto.model.SaleDto;
import tezAlServer.service.Impl.OrderServiceImpl;

import java.util.List;
import java.util.Optional;

@Api(description = "Операции по взаимодействию с заказами")
@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private SaleMapper saleMapper;

    @ApiOperation(value = "Получения списка всех заказов")
    @GetMapping
    public ResponseEntity<List<OrderDto>> List(){
        return ResponseEntity.ok(orderMapper.toOrderDtos(orderService.findAll()));
    }

    @ApiOperation(value = "Получения списка всех заказов одного контейнера")
    @GetMapping("{id}/all")
    public ResponseEntity<List<OrderDto>> getAllById(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderMapper.toOrderDtos(orderService.findAllById(id)));
    }


    @ApiOperation(value = "Создание заказа")
    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto  orderDto, @RequestBody List<Sale> sale){
        orderService.save(orderMapper.toOrder(orderDto));
        orderService.proceedToCheckout(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }


    @ApiOperation(value = "Получения списка всех товаров в корзине")
    @GetMapping("/checkout/all/{id}")
    public ResponseEntity<List<SaleDto>> getAllItemInCart(@PathVariable("id") Long id){
        return ResponseEntity.ok(saleMapper.toSaleDtos(orderService.allRateInCart(id)));
    }

    @ApiOperation(value = "Удаление списка всех товаров в корзине")
    @DeleteMapping("/checkout/all/{id}")
    public ResponseEntity<OrderDto> clearAllItemInCart(@PathVariable("id") Long id){
        orderService.clearAllRateInCart(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @ApiOperation(value = "Создание корзины")
    @PostMapping("/checkout/{containerId}/{clientId}")
    public ResponseEntity<OrderDto> createCart(@PathVariable("containerId") Long containerId, @PathVariable("clientId") Long clientId, @RequestBody Sale sale){
        orderService.createCart(containerId, clientId, sale);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @ApiOperation(value = "Получение информации о заказе")
    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOne(@PathVariable("id") Long id){
        Optional<Order> order = orderService.findById(id);
        return order.isPresent() ?
                ResponseEntity.ok(orderMapper.toOrderDto(order.get())) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ApiOperation(value = "Обновление заказов")
    @PutMapping("{id}")
    public ResponseEntity<OrderDto> update(@PathVariable("id") Long id,
            @RequestBody OrderDto orderDto) {
        Order order = orderMapper.toOrder(orderDto);
        order.setId(id);
        orderService.save(order);
        return ResponseEntity.ok(orderDto);
    }

    @ApiOperation(value = "Удаление заказов")
    @DeleteMapping("{id}")
    public  ResponseEntity<OrderDto> delete(@PathVariable("id") Long id){
        orderService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
