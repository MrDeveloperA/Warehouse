package com.example.warehouse.projection;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Input;
import com.example.warehouse.entity.Supplier;
import com.example.warehouse.entity.Warehouse;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(types = Currency.class)
public interface CustomCurrency {
    Integer getId();
    String getName();
    boolean getActive();
}
