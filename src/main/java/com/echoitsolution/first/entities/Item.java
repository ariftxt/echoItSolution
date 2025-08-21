package com.echoitsolution.first.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Order")
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String type;

    private Boolean inStoke;

    private Long price;

    public Item(Long id, String name, String type, Boolean inStoke, Long price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.inStoke = inStoke;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Boolean getInStoke() {
        return inStoke;
    }

    public Long getPrice() {
        return price;
    }
}
