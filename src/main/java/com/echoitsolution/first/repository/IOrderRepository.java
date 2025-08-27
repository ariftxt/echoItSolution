package com.echoitsolution.first.repository;

import com.echoitsolution.first.entities.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.status = ?1")
    List<Order> findByStatus(String status, Pageable pageable);

    @Query("select count(o) from Order o where o.status = ?1")
    Long findCountByStatus(String status);

    Long countByStatus(String status);

}
