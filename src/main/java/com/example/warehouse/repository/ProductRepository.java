package com.example.warehouse.repository;

import com.example.warehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByNameAndCategoryId(String name, Integer category_id);
}
