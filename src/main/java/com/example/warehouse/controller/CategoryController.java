package com.example.warehouse.controller;

import com.example.warehouse.entity.Category;
import com.example.warehouse.entity.Measurement;
import com.example.warehouse.payload.CategoryDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public Result addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    //    Get
    @GetMapping
    public List<Category> getMeasurement() {
        return categoryService.getCategories();
    }

    //    Get by id
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        return categoryService.editCategory(id, categoryDto);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteCategory(@PathVariable Integer id) {
        return categoryService.deleteCategory(id);
    }
}
