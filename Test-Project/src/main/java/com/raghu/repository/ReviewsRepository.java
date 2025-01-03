package com.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghu.entity.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

}
