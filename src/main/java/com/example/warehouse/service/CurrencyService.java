package com.example.warehouse.service;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Measurement;
import com.example.warehouse.payload.Result;
import com.example.warehouse.repository.CurrencyRepository;
import com.example.warehouse.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addCurrency(Currency currency) {
        boolean existsByName = currencyRepository.existsByName(currency.getName());
        if (existsByName)
            return new Result("Such currency already exist", false);
        currencyRepository.save(currency);
        return new Result("Saved successfully", true);
    }

    //    Get List
    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    //    Get by id
    public Currency getCurrencyById(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent())
            return new Currency();
        return optionalCurrency.get();
    }

    //    Update
    public Result ediCurrency(Integer id, Currency currency) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent())
            return new Result("Such currency was not found", false);
        Currency editCurrency = optionalCurrency.get();
        editCurrency.setName(currency.getName());
        currencyRepository.save(editCurrency);
        return new Result("Edited successfully", true);
    }

    //     Delete
    public Result deleteCurrency(Integer id) {
        try {
            currencyRepository.deleteById(id);
            return new Result("Currency was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
