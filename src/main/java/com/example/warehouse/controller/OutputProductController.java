package com.example.warehouse.controller;

import com.example.warehouse.entity.InputProduct;
import com.example.warehouse.entity.OutputProduct;
import com.example.warehouse.payload.InputProductDto;
import com.example.warehouse.payload.OutputProductDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.InputProductService;
import com.example.warehouse.service.OutputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;

    @PostMapping
    public Result addOutputProduct(@RequestBody OutputProductDto outputProductDto) {
        return outputProductService.addOutputProduct(outputProductDto);
    }

    //    Get
    @GetMapping
    public List<OutputProduct> getOutputProduct() {
        return outputProductService.getOutputProducts();
    }

    //    Get by id
    @GetMapping("/{id}")
    public OutputProduct getOutputProductById(@PathVariable Integer id) {
        return outputProductService.getOutputProductById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editOutputProduct(@PathVariable Integer id, @RequestBody OutputProductDto outputProductDto) {
        return outputProductService.editOutputProduct(id, outputProductDto);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteOutputProduct(@PathVariable Integer id) {
        return outputProductService.deleteOutputProduct(id);
    }
}
