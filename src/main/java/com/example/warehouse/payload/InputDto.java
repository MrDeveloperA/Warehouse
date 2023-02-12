package com.example.warehouse.payload;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Supplier;
import com.example.warehouse.entity.Warehouse;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class InputDto {
    private Timestamp date;
    private Integer warehouse;
    private Integer supplier;
    private Integer currency;
    private String factureNumber;
    private String code;
}
