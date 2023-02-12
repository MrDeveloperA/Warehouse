package com.example.warehouse.controller;

import com.example.warehouse.entity.Measurement;
import com.example.warehouse.entity.Product;
import com.example.warehouse.payload.ProductDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationSupport;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public Result addProduct(@RequestBody ProductDto productDto) {
        Result result = productService.addProduct(productDto);
        return result;
    }

    //    Get
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    //    Get by id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return productService.editProduct(id, productDto);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }
}
