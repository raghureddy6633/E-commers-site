package com.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghu.entity.CartItems;

public interface CartItemsRepository extends JpaRepository<CartItems, Long> {

}
