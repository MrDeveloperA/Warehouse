package com.example.warehouse.projection;

import com.example.warehouse.entity.Supplier;
import com.example.warehouse.entity.Warehouse;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Supplier.class)
public interface CustomSupplier {
    Integer getId();
    String getName();
    boolean getActive();
    String getPhoneNumber();
}
