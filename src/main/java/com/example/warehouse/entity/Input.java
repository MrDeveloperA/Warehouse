package com.example.warehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp date;
    @ManyToOne
    private Warehouse warehouse;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne
    private Currency currency;
    private String factureNumber;
    @Column(unique = true, nullable = false)
    private String code;
}
