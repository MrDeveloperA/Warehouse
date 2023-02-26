package com.example.warehouse.repository;

import com.example.warehouse.entity.Supplier;
import com.example.warehouse.projection.CustomSupplier;
import com.example.warehouse.projection.CustomWarehouse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "supplier", collectionResourceRel = "list", excerptProjection = CustomSupplier.class)
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
