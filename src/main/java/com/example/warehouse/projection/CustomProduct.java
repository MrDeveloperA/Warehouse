package com.example.warehouse.projection;

import com.example.warehouse.entity.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class)
public interface CustomProduct {
    Integer getId();
    String getName();
    boolean getActive();
    Category getCategory();
    Attachment getPhoto();
    String getCode();
    Measurement getMeasurement();
}
