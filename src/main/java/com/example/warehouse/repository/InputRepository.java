package com.example.warehouse.repository;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Input;
import com.example.warehouse.projection.CustomInput;
import com.example.warehouse.projection.CustomWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "input", collectionResourceRel = "list", excerptProjection = CustomInput.class)
public interface InputRepository extends JpaRepository<Input, Integer> {

}
