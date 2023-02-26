package com.example.warehouse.projection;

import com.example.warehouse.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(types = Input.class)
public interface CustomInput {
    Integer getId();
    Timestamp getDate();
    Warehouse getWarehouse();
    Supplier getSupplier();
    Currency getCurrency();
    String getFactureNumber();
    String getCode();
}
