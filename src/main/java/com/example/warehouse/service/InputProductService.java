package com.example.warehouse.service;

import com.example.warehouse.entity.*;
import com.example.warehouse.payload.InputDto;
import com.example.warehouse.payload.InputProductDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;

    public Result addInputProduct(InputProductDto inputProductDto) {
        InputProduct inputProduct = new InputProduct();

        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProduct());
        if (!optionalProduct.isPresent())
            return new Result("Such product was not found", false);
        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireDate(inputProductDto.getExpireDate());

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInput());
        if (!optionalInput.isPresent())
            return new Result("Such input was not found", false);
        inputProduct.setInput(optionalInput.get());

        inputProductRepository.save(inputProduct);
        return new Result("Saved successfully", true);
    }

    //    Get List
    public List<InputProduct> getInputProducts() {
        return inputProductRepository.findAll();
    }

    //    Get by id
    public InputProduct getInputProductById(Integer id) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent())
            return new InputProduct();
        return optionalInputProduct.get();
    }

    //    Update
    public Result editInputProduct(Integer id, InputProductDto inputProductDto) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent())
            return new Result("Such inputProduct was not found", false);

        InputProduct editInputProduct = optionalInputProduct.get();

        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProduct());
        if (!optionalProduct.isPresent())
            return new Result("Such product was not found", false);
        editInputProduct.setProduct(optionalProduct.get());
        editInputProduct.setAmount(inputProductDto.getAmount());
        editInputProduct.setPrice(inputProductDto.getPrice());
        editInputProduct.setExpireDate(inputProductDto.getExpireDate());

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInput());
        if (!optionalInput.isPresent())
            return new Result("Such input was not found", false);
        editInputProduct.setInput(optionalInput.get());

        inputProductRepository.save(editInputProduct);
        return new Result("Edited successfully", true);
    }

    //     Delete
    public Result deleteInputProduct(Integer id) {
        try {
            inputProductRepository.deleteById(id);
            return new Result("Input Product was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
