package com.echoitsolution.first.controller;

import com.echoitsolution.first.entities.Order;
import com.echoitsolution.first.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderService;

    @GetMapping(value = "get/all")
    public Page<Order> getAll(
            @RequestParam int page,
            @RequestParam int size
    ){
        return orderService.getAllUsingCustomPagination(page, size);
    }


}
