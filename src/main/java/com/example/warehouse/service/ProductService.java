package com.example.warehouse.service;

import com.example.warehouse.entity.Attachment;
import com.example.warehouse.entity.Category;
import com.example.warehouse.entity.Measurement;
import com.example.warehouse.entity.Product;
import com.example.warehouse.payload.ProductDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.repository.AttachmentRepository;
import com.example.warehouse.repository.CategoryRepository;
import com.example.warehouse.repository.MeasurementRepository;
import com.example.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addProduct(ProductDto productDto) {
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategory());
        if (existsByNameAndCategoryId) {
            return new Result("Such product is already exist", false);
        }
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategory());
        if (!optionalCategory.isPresent()) {
            return new Result("Such category was not found", false);
        }

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhoto());
        if (!optionalAttachment.isPresent())
            return new Result("Such photo was not found", false);

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurement());
        if (!optionalMeasurement.isPresent())
            return new Result("Such measurement was not found", false);

        Product product = new Product();
        product.setName(productDto.getName());
        product.setCode(String.valueOf(product.getId() + 1));
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());

        productRepository.save(product);
        return new Result("Product saved successfully", true);
    }

    //    Get List
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    //    Get by id
    public Product getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new Product();
        return optionalProduct.get();
    }

    //    Update
    public Result editProduct(Integer id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new Result("Such product was not found", false);

        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategory());
        if (existsByNameAndCategoryId) {
            return new Result("Such product is already exist", false);
        }
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategory());
        if (!optionalCategory.isPresent()) {
            return new Result("Such category was not found", false);
        }

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhoto());
        if (!optionalAttachment.isPresent())
            return new Result("Such photo was not found", false);

        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurement());
        if (!optionalMeasurement.isPresent())
            return new Result("Such measurement was not found", false);

        Product editProduct = optionalProduct.get();
        editProduct.setName(productDto.getName());
        editProduct.setCode(String.valueOf(editProduct.getId() + 1));
        editProduct.setCategory(optionalCategory.get());
        editProduct.setPhoto(optionalAttachment.get());
        editProduct.setMeasurement(optionalMeasurement.get());

        productRepository.save(editProduct);
        return new Result("Product edited successfully", true);

    }

    //     Delete
    public Result deleteProduct(Integer id) {
        try {
            productRepository.deleteById(id);
            return new Result("Product was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
