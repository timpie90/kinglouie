package com.vodafoneziggo.kinglouie.order;

import com.vodafoneziggo.kinglouie.dto.NewOrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    private final OrderService service;

    OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/orders")
    List<Order> all() {
        return service.findAll();
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    UUID newOrder(@RequestBody NewOrderDto newOrder) {
        return service.create(newOrder);
    }

}
