package com.example.warehouse.service;

import com.example.warehouse.repository.MeasurementRepository;
import com.example.warehouse.entity.Measurement;
import com.example.warehouse.payload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurementService(Measurement measurement) {
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName)
            return new Result("Bunday o'lchov birligi mavjud", false);
        measurementRepository.save(measurement);
        return new Result("Saved successfully", true);
    }

    //    Get Measurement List
    public List<Measurement> getMeasurements() {
        return measurementRepository.findAll();
    }

    //    Get measurement by id
    public Measurement getMeasurementById(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return new Measurement();
        return optionalMeasurement.get();
    }

    //    Edit measurement
    public Result editMeasurement(Integer id, Measurement measurement) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return new Result("Such measurement was not found", false);
        Measurement editMeasurement = optionalMeasurement.get();
        editMeasurement.setName(measurement.getName());
        measurementRepository.save(editMeasurement);
        return new Result("Edited successfully", true);
    }

    //     Delete
    public Result deleteMeasurement(Integer id) {
        try {
            measurementRepository.deleteById(id);
            return new Result("Measurement was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
