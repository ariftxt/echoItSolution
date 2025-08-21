package com.echoitsolution.first.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer quantity;

    private String type;

    private String status;

    private Date createdOn;

    private Long createdBy;

    public Order(Long id, String name, Integer quantity, String type, String status, Date createdOn, Long createdBy) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.status = status;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Long getCreatedBy() {
        return createdBy;
    }
}
