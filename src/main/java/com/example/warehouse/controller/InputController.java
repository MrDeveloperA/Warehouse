package com.example.warehouse.controller;

import com.example.warehouse.entity.Category;
import com.example.warehouse.entity.Input;
import com.example.warehouse.payload.CategoryDto;
import com.example.warehouse.payload.InputDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.CategoryService;
import com.example.warehouse.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;

    @PostMapping
    public Result addInput(@RequestBody InputDto inputDto) {
        return inputService.addInput(inputDto);
    }

    //    Get
    @GetMapping
    public List<Input> getInput() {
        return inputService.getInputs();
    }

    //    Get by id
    @GetMapping("/{id}")
    public Input getInputById(@PathVariable Integer id) {
        return inputService.getInputById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editInput(@PathVariable Integer id, @RequestBody InputDto inputDto) {
        return inputService.editInput(id, inputDto);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteInput(@PathVariable Integer id) {
        return inputService.deleteInput(id);
    }
}
