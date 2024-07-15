package com.claudioESandrade.gameShop.Controller;

import com.claudioESandrade.gameShop.Entity.Order;
import com.claudioESandrade.gameShop.Service.Implementations.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            orderService.save( order );
            return new ResponseEntity<>("Order was created successfully.", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/get/All")
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok().body(orderService.getAll() );
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById( id ) );
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        orderService.update( id, order);
        return ResponseEntity.ok( ).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.delete( id );
        return ResponseEntity.ok().build();
    }

}
