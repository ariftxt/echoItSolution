package com.echoitsolution.first.service;

import com.echoitsolution.first.entities.Order;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();

    Page<Order> getAllInPagination(int page, int size);

    Page<Order> getAllUsingCustomPagination(int page, int size);

}
