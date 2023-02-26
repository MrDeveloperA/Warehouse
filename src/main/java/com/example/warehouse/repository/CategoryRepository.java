package com.example.warehouse.repository;

import com.example.warehouse.entity.Category;
import com.example.warehouse.projection.CustomCategory;
import com.example.warehouse.projection.CustomWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "category", excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
