package com.example.warehouse.service;

import com.example.warehouse.entity.Client;
import com.example.warehouse.entity.Supplier;
import com.example.warehouse.payload.Result;
import com.example.warehouse.repository.ClientRepository;
import com.example.warehouse.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Result addSupplier(Supplier supplier) {
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(supplier.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("Such supplier with this phone number already exist", false);
        supplierRepository.save(supplier);
        return new Result("Saved successfully", true);
    }

    //    Get List
    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    //    Get by id
    public Supplier getSupplierById(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Supplier();
        return optionalSupplier.get();
    }

    //    Update
    public Result editSupplier(Integer id, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Result("Such supplier was not found", false);
        Supplier editSupplier = optionalSupplier.get();
        editSupplier.setName(supplier.getName());
        editSupplier.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(editSupplier);
        return new Result("Edited successfully", true);
    }

    //     Delete
    public Result deleteSupplier(Integer id) {
        try {
            supplierRepository.deleteById(id);
            return new Result("Supplier was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
