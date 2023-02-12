package com.example.warehouse.controller;

import com.example.warehouse.entity.Input;
import com.example.warehouse.entity.InputProduct;
import com.example.warehouse.payload.InputDto;
import com.example.warehouse.payload.InputProductDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.InputProductService;
import com.example.warehouse.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inputProduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;

    @PostMapping
    public Result addInputProduct(@RequestBody InputProductDto inputProductDto) {
        return inputProductService.addInputProduct(inputProductDto);
    }

    //    Get
    @GetMapping
    public List<InputProduct> getInputProduct() {
        return inputProductService.getInputProducts();
    }

    //    Get by id
    @GetMapping("/{id}")
    public InputProduct getInputProductById(@PathVariable Integer id) {
        return inputProductService.getInputProductById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editInputProduct(@PathVariable Integer id, @RequestBody InputProductDto inputProductDto) {
        return inputProductService.editInputProduct(id, inputProductDto);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteInputProduct(@PathVariable Integer id) {
        return inputProductService.deleteInputProduct(id);
    }
}
