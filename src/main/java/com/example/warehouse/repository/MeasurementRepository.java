package com.example.warehouse.repository;

import com.example.warehouse.entity.Measurement;
import com.example.warehouse.projection.CustomMeasurement;
import com.example.warehouse.projection.CustomWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "measurement", collectionResourceRel = "list", excerptProjection = CustomMeasurement.class)
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
boolean existsByName(String name);
}
