package com.example.warehouse.repository;

import com.example.warehouse.entity.InputProduct;
import com.example.warehouse.entity.OutputProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {

}
