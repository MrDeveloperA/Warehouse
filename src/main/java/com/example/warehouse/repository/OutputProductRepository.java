package com.example.warehouse.repository;

import com.example.warehouse.entity.InputProduct;
import com.example.warehouse.entity.OutputProduct;
import com.example.warehouse.projection.CustomOutputProduct;
import com.example.warehouse.projection.CustomWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "outputProduct", collectionResourceRel = "list", excerptProjection = CustomOutputProduct.class)
public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {

}
