package com.example.warehouse.projection;

import com.example.warehouse.entity.Client;
import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Output;
import com.example.warehouse.entity.Warehouse;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(types = Output.class)
public interface CustomOutput {
    Integer getId();
    Timestamp getDate();
    Warehouse getWarehouse();
    Client getClient();
    Currency getCurrency();
    String getFactureNumber();
    String getCode();
}
