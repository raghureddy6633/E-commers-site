package com.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghu.entity.ShoppingCart;

public interface ShoppingCartRepository  extends JpaRepository<ShoppingCart, Long> {

}
