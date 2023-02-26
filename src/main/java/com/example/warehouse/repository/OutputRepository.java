package com.example.warehouse.repository;

import com.example.warehouse.entity.Input;
import com.example.warehouse.entity.Output;
import com.example.warehouse.projection.CustomOutput;
import com.example.warehouse.projection.CustomWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "output", collectionResourceRel = "list", excerptProjection = CustomOutput.class)
public interface OutputRepository extends JpaRepository<Output, Integer> {

}
