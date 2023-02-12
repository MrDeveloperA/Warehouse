package com.example.warehouse.service;

import com.example.warehouse.entity.*;
import com.example.warehouse.payload.InputDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addInput(InputDto inputDto) {
        Input input = new Input();
        input.setDate(inputDto.getDate());

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouse());
        if (!optionalWarehouse.isPresent())
            return new Result("Such warehouse was not found", false);
        input.setWarehouse(optionalWarehouse.get());

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplier());
        if (!optionalSupplier.isPresent())
            return new Result("Such supplier was not found", false);
        input.setSupplier(optionalSupplier.get());

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrency());
        if (!optionalCurrency.isPresent())
            return new Result("Such currency was not found", false);
        input.setCurrency(optionalCurrency.get());

        input.setFactureNumber(inputDto.getFactureNumber());
        input.setCode(inputDto.getCode());

        inputRepository.save(input);
        return new Result("Saved successfully", true);
    }

    //    Get List
    public List<Input> getInputs() {
        return inputRepository.findAll();
    }

    //    Get by id
    public Input getInputById(Integer id) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent())
            return new Input();
        return optionalInput.get();
    }

    //    Update
    public Result editInput(Integer id, InputDto inputDto) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent())
            return new Result("Such input was not found", false);

        Input editInput = optionalInput.get();

        editInput.setDate(inputDto.getDate());

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouse());
        if (!optionalWarehouse.isPresent())
            return new Result("Such warehouse was not found", false);
        editInput.setWarehouse(optionalWarehouse.get());

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplier());
        if (!optionalSupplier.isPresent())
            return new Result("Such supplier was not found", false);
        editInput.setSupplier(optionalSupplier.get());

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrency());
        if (!optionalCurrency.isPresent())
            return new Result("Such currency was not found", false);
        editInput.setCurrency(optionalCurrency.get());

        editInput.setFactureNumber(inputDto.getFactureNumber());
        editInput.setCode(inputDto.getCode());

        inputRepository.save(editInput);
        return new Result("Saved successfully", true);
    }

    //     Delete
    public Result deleteInput(Integer id) {
        try {
            inputRepository.deleteById(id);
            return new Result("Input was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
