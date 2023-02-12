package com.example.warehouse.service;

import com.example.warehouse.entity.*;
import com.example.warehouse.payload.InputDto;
import com.example.warehouse.payload.OutputDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addOutput(OutputDto outputDto) {
        Output output = new Output();
        output.setDate(outputDto.getDate());

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouse());
        if (!optionalWarehouse.isPresent())
            return new Result("Such warehouse was not found", false);
        output.setWarehouse(optionalWarehouse.get());

        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClient());
        if (!optionalClient.isPresent())
            return new Result("Such Client was not found", false);
        output.setClient(optionalClient.get());

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrency());
        if (!optionalCurrency.isPresent())
            return new Result("Such currency was not found", false);
        output.setCurrency(optionalCurrency.get());

        output.setFactureNumber(outputDto.getFactureNumber());
        output.setCode(outputDto.getCode());

        outputRepository.save(output);
        return new Result("Saved successfully", true);
    }

    //    Get List
    public List<Output> getOutputs() {
        return outputRepository.findAll();
    }

    //    Get by id
    public Output getOutputById(Integer id) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent())
            return new Output();
        return optionalOutput.get();
    }

    //    Update
    public Result editOutput(Integer id, OutputDto outputDto) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent())
            return new Result("Such output was not found", false);

        Output editOutput = optionalOutput.get();

        editOutput.setDate(outputDto.getDate());

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouse());
        if (!optionalWarehouse.isPresent())
            return new Result("Such warehouse was not found", false);
        editOutput.setWarehouse(optionalWarehouse.get());

        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClient());
        if (!optionalClient.isPresent())
            return new Result("Such Client was not found", false);
        editOutput.setClient(optionalClient.get());

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrency());
        if (!optionalCurrency.isPresent())
            return new Result("Such currency was not found", false);
        editOutput.setCurrency(optionalCurrency.get());

        editOutput.setFactureNumber(outputDto.getFactureNumber());
        editOutput.setCode(outputDto.getCode());

        outputRepository.save(editOutput);
        return new Result("Edited successfully", true);

    }

    //     Delete
    public Result deleteOutput(Integer id) {
        try {
            outputRepository.deleteById(id);
            return new Result("Output was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
