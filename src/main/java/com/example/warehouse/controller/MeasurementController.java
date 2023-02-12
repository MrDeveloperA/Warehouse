package com.example.warehouse.controller;

import com.example.warehouse.entity.Measurement;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;

    //    Add
    @PostMapping
    public Result addMeasurementController(@RequestBody Measurement measurement) {
        return measurementService.addMeasurementService(measurement);
    }

    //    Get
    @GetMapping
    public List<Measurement> getMeasurement() {
        return measurementService.getMeasurements();
    }

    //    Get by id
    @GetMapping("/{id}")
    public Measurement getMeasurementById(@PathVariable Integer id) {
        return measurementService.getMeasurementById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editMeasurement(@PathVariable Integer id, @RequestBody Measurement measurement) {
        return measurementService.editMeasurement(id, measurement);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id) {
        return measurementService.deleteMeasurement(id);
    }
}
