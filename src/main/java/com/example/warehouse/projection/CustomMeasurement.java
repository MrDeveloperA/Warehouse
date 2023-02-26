package com.example.warehouse.projection;

import com.example.warehouse.entity.*;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;

@Projection(types = Measurement.class)
public interface CustomMeasurement {
    Integer getId();
    String getName();
    boolean getActive();
}
