package com.example.warehouse.service;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.payload.Result;
import com.example.warehouse.repository.CurrencyRepository;
import com.example.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addWarehouse(Warehouse warehouse) {
        boolean existsByName = warehouseRepository.existsByName(warehouse.getName());
        if (existsByName)
            return new Result("Such warehouse already exist", false);
        warehouseRepository.save(warehouse);
        return new Result("Saved successfully", true);
    }

    //    Get List
    public List<Warehouse> getWarehouses() {
        return warehouseRepository.findAll();
    }

    //    Get by id
    public Warehouse getWarehouseById(Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent())
            return new Warehouse();
        return optionalWarehouse.get();
    }

    //    Update
    public Result ediWarehouse(Integer id, Warehouse warehouse) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent())
            return new Result("Such warehouse was not found", false);
        Warehouse editWarehouse = optionalWarehouse.get();
        editWarehouse.setName(warehouse.getName());
        warehouseRepository.save(editWarehouse);
        return new Result("Edited successfully", true);
    }

    //     Delete
    public Result deleteWarehouse(Integer id) {
        try {
            warehouseRepository.deleteById(id);
            return new Result("Warehouse was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
