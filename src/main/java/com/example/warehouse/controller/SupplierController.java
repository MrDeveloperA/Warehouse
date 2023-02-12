package com.example.warehouse.controller;

import com.example.warehouse.entity.Client;
import com.example.warehouse.entity.Supplier;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.ClientService;
import com.example.warehouse.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    //    Add
    @PostMapping
    public Result addSupplier(@RequestBody Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }

    //    Get
    @GetMapping
    public List<Supplier> getSupplier() {
        return supplierService.getSuppliers();
    }

    //    Get by id
    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Integer id) {
        return supplierService.getSupplierById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editSupplier(@PathVariable Integer id, @RequestBody Supplier supplier) {
        return supplierService.editSupplier(id, supplier);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteSupplier(@PathVariable Integer id) {
        return supplierService.deleteSupplier(id);
    }
}
