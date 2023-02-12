package com.example.warehouse.payload;

import com.example.warehouse.entity.Output;
import com.example.warehouse.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Date;

@Data
public class OutputProductDto {
    private Integer product;
    private Double amount;
    private Double price;
    private Integer output;
}
