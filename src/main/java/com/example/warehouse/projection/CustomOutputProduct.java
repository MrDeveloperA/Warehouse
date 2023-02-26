package com.example.warehouse.projection;

import com.example.warehouse.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(types = OutputProduct.class)
public interface CustomOutputProduct {
    Integer getId();
    Product getProduct();
    Double getAmount();
    Double getPrice();
    Output getOutput();
}
