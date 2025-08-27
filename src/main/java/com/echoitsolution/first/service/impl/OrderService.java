package com.echoitsolution.first.service.impl;

import com.echoitsolution.first.entities.Order;
import com.echoitsolution.first.repository.IOrderRepository;
import com.echoitsolution.first.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Page<Order> getAllInPagination(int page, int size) {
        return orderRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Order> getAllUsingCustomPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Order> ordersList = orderRepository.findByStatus("ACTIVE", pageable);
        Long totalCount = orderRepository.countByStatus("ACTIVE");

        return new PageImpl<>(ordersList, pageable, totalCount);
    }
}
