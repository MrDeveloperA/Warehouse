package com.example.warehouse.repository;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input, Integer> {

}
