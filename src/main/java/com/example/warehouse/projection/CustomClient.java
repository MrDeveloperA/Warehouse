package com.example.warehouse.projection;

import com.example.warehouse.entity.Client;
import com.example.warehouse.entity.Currency;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Client.class)
public interface CustomClient {
    Integer getId();
    String getName();
    boolean getActive();
    String getPhoneNumber();
}
