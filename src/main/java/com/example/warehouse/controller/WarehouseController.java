package com.example.warehouse.controller;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.CurrencyService;
import com.example.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    //    Add
    @PostMapping
    public Result addWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.addWarehouse(warehouse);
    }

    //    Get
    @GetMapping
    public List<Warehouse> getWarehouse() {
        return warehouseService.getWarehouses();
    }

    //    Get by id
    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable Integer id) {
        return warehouseService.getWarehouseById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editWarehouse(@PathVariable Integer id, @RequestBody Warehouse warehouse) {
        return warehouseService.ediWarehouse(id, warehouse);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteWarehouse(@PathVariable Integer id) {
        return warehouseService.deleteWarehouse(id);
    }
}
