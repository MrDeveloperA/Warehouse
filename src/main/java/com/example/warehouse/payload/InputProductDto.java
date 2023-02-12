package com.example.warehouse.payload;

import com.example.warehouse.entity.Input;
import com.example.warehouse.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class InputProductDto {
    private Integer product;
    private Double amount;
    private Double price;
    private Date expireDate;
    private Integer input;
}
