package com.example.warehouse.controller;

import com.example.warehouse.entity.Client;
import com.example.warehouse.entity.Measurement;
import com.example.warehouse.payload.Result;
import com.example.warehouse.service.ClientService;
import com.example.warehouse.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    //    Add
    @PostMapping
    public Result addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    //    Get
    @GetMapping
    public List<Client> getClient() {
        return clientService.getClients();
    }

    //    Get by id
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editClient(@PathVariable Integer id, @RequestBody Client client) {
        return clientService.editClient(id, client);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteClient(@PathVariable Integer id) {
        return clientService.deleteClient(id);
    }
}
