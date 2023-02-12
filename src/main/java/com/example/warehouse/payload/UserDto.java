package com.example.warehouse.payload;

import com.example.warehouse.entity.Warehouse;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String code;
    private String password;
    private boolean active = true;
    private Integer warehouses;
}
