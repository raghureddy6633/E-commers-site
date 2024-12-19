package com.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghu.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
