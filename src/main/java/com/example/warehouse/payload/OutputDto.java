package com.example.warehouse.payload;

import com.example.warehouse.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OutputDto {
    private Timestamp date;
    private Integer warehouse;
    private Integer client;
    private Integer currency;
    private String factureNumber;
    private String code;
}
