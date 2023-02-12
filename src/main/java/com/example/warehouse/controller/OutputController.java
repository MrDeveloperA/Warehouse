package com.example.warehouse.controller;

import com.example.warehouse.entity.Input;
import com.example.warehouse.entity.Output;
import com.example.warehouse.payload.InputDto;
import com.example.warehouse.payload.OutputDto;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.InputService;
import com.example.warehouse.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    @PostMapping
    public Result addOutput(@RequestBody OutputDto outputDto) {
        return outputService.addOutput(outputDto);
    }

    //    Get
    @GetMapping
    public List<Output> getOutput() {
        return outputService.getOutputs();
    }

    //    Get by id
    @GetMapping("/{id}")
    public Output getOutputById(@PathVariable Integer id) {
        return outputService.getOutputById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editOutput(@PathVariable Integer id, @RequestBody OutputDto outputDto) {
        return outputService.editOutput(id, outputDto);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteOutput(@PathVariable Integer id) {
        return outputService.deleteOutput(id);
    }
}
