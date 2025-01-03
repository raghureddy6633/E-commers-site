package com.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghu.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
