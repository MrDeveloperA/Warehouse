package com.example.warehouse.projection;

import com.example.warehouse.entity.User1;
import com.example.warehouse.entity.Warehouse;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(types = User1.class)
public interface CustomUser1 {
    Integer getId();
    String getFirstName();
    String getLastName();
    String getPhoneNumber();
    String getCode();
    String getPassword();
    boolean getActive();
    Set<Warehouse> getWarehouses();
}
