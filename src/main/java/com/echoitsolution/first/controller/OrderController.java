package com.echoitsolution.first.controller;

import com.echoitsolution.first.entities.Item;
import com.echoitsolution.first.entities.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping(value = "get/all")
    public List<Order> getAll(){
        return List.of(
                new Order(1L, "Water Bottle", 10, "Beverage", "Pending", new Date(), 101L),
                new Order(2L, "Rice Bag", 5, "Grocery", "Shipped", new Date(), 102L),
                new Order(3L, "Laptop", 1, "Electronics", "Delivered", new Date(), 103L)
        );
    }
}
