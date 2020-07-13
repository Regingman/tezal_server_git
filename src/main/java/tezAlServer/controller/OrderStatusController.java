package tezAlServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tezAlServer.domain.OrderStatus;
import tezAlServer.service.OrderStatusService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("orderStatus")
public class OrderStatusController {
    @Autowired
    OrderStatusService orderStatusService;

    @GetMapping
    public ResponseEntity<List<OrderStatus>> getAll(){
        return ResponseEntity.ok(orderStatusService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderStatus> getStatusById( @PathVariable("id") Long id){
        Optional<OrderStatus> orderStatus = orderStatusService.findById(id);
        return orderStatus.isPresent() ?
                ResponseEntity.ok(orderStatus.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }



}
