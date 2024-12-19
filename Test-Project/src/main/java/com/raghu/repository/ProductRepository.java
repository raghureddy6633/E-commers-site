package com.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghu.entity.Product;
import com.raghu.entity.User;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}
