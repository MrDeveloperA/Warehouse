package com.example.warehouse.repository;

import com.example.warehouse.entity.Input;
import com.example.warehouse.entity.InputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {

}
