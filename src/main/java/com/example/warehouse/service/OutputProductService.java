package com.example.warehouse.service;

import com.example.warehouse.entity.*;
import com.example.warehouse.payload.InputProductDto;
import com.example.warehouse.payload.OutputProductDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepository outputRepository;

    public Result addOutputProduct(OutputProductDto outputProductDto) {
        OutputProduct outputProduct = new OutputProduct();

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProduct());
        if (!optionalProduct.isPresent())
            return new Result("Such product was not found", false);
        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutput());
        if (!optionalOutput.isPresent())
            return new Result("Such output was not found", false);
        outputProduct.setOutput(optionalOutput.get());

        outputProductRepository.save(outputProduct);
        return new Result("Saved successfully", true);
    }

    //    Get List
    public List<OutputProduct> getOutputProducts() {
        return outputProductRepository.findAll();
    }

    //    Get by id
    public OutputProduct getOutputProductById(Integer id) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (!optionalOutputProduct.isPresent())
            return new OutputProduct();
        return optionalOutputProduct.get();
    }

    //    Update
    public Result editOutputProduct(Integer id, OutputProductDto outputProductDto) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (!optionalOutputProduct.isPresent())
            return new Result("Such outputProduct was not found", false);

        OutputProduct editOutputProduct = optionalOutputProduct.get();

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProduct());
        if (!optionalProduct.isPresent())
            return new Result("Such product was not found", false);
        editOutputProduct.setProduct(optionalProduct.get());
        editOutputProduct.setAmount(outputProductDto.getAmount());
        editOutputProduct.setPrice(outputProductDto.getPrice());

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutput());
        if (!optionalOutput.isPresent())
            return new Result("Such output was not found", false);
        editOutputProduct.setOutput(optionalOutput.get());

        outputProductRepository.save(editOutputProduct);
        return new Result("Saved successfully", true);
    }

    //     Delete
    public Result deleteOutputProduct(Integer id) {
        try {
            outputProductRepository.deleteById(id);
            return new Result("Output Product was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
