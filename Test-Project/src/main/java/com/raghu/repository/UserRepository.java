package com.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghu.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
