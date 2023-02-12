package com.example.warehouse.controller;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Measurement;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.CurrencyService;
import com.example.warehouse.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    //    Add
    @PostMapping
    public Result addCurrency(@RequestBody Currency currency) {
        return currencyService.addCurrency(currency);
    }

    //    Get
    @GetMapping
    public List<Currency> getCurrency() {
        return currencyService.getCurrencies();
    }

    //    Get by id
    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Integer id) {
        return currencyService.getCurrencyById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editCurrency(@PathVariable Integer id, @RequestBody Currency currency) {
        return currencyService.ediCurrency(id, currency);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteCurrency(@PathVariable Integer id) {
        return currencyService.deleteCurrency(id);
    }
}
