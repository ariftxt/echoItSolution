package com.echoitsolution.first.controller;

import com.echoitsolution.first.entities.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @GetMapping(value = "get/all")
    public List<Item> getAll(){
        return List.of(
                new Item(1L, "water", "Bottle", true, 40L),
                new Item(2L, "water", "jar", true, 110L),
                new Item(3L, "water", "tanker", true, 1000L)
        );
    }
}
