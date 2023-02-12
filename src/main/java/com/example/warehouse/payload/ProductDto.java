package com.example.warehouse.payload;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private Integer category;
    private Integer photo;
    private String code;
    private Integer measurement;
}
