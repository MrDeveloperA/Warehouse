package com.example.warehouse.repository;

import com.example.warehouse.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User1, Integer> {

}
