package com.example.warehouse.repository;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Measurement;
import com.example.warehouse.projection.CustomCurrency;
import com.example.warehouse.projection.CustomWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "currency", collectionResourceRel = "list", excerptProjection = CustomCurrency.class)
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
boolean existsByName(String name);
}
