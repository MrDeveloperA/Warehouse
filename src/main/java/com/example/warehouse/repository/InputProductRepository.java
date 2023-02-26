package com.example.warehouse.repository;

import com.example.warehouse.entity.Input;
import com.example.warehouse.entity.InputProduct;
import com.example.warehouse.projection.CustomInputProduct;
import com.example.warehouse.projection.CustomWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "inputProduct", collectionResourceRel = "list", excerptProjection = CustomInputProduct.class)
public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {

}
