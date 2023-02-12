package com.example.warehouse.service;

import com.example.warehouse.entity.Category;
import com.example.warehouse.entity.Measurement;
import com.example.warehouse.payload.CategoryDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.repository.CategoryRepository;
import com.example.warehouse.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Result addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());

        if (categoryDto.getParentCategory() != null) {
            Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategory());
            if (optionalParentCategory.isPresent())
                return new Result("Such parent category was not found", false);
            category.setParentCategoryId(optionalParentCategory.get());
        }
        categoryRepository.save(category);
        return new Result("Saved successfully", true);
    }


    //    Get Category List
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    //    Get category by id
    public Category getCategoryById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Category();
        return optionalCategory.get();
    }

    //    Update category
    public Result editCategory(Integer id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("Such category was not found to edit", false);

        Category editCategory = optionalCategory.get();
        editCategory.setName(categoryDto.getName());

        if (categoryDto.getParentCategory() != null) {
            Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategory());
            if (optionalParentCategory.isPresent())
                return new Result("Such parent category was not found", false);
            editCategory.setParentCategoryId(optionalParentCategory.get());
        }
        categoryRepository.save(editCategory);
        return new Result("Saved successfully", true);
    }

    //     Delete
    public Result deleteCategory(Integer id) {
        try {
            categoryRepository.deleteById(id);
            return new Result("Category was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
