package com.example.warehouse.service;

import com.example.warehouse.entity.Client;
import com.example.warehouse.entity.Measurement;
import com.example.warehouse.payload.Result;
import com.example.warehouse.repository.ClientRepository;
import com.example.warehouse.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Result addClient(Client client) {
        boolean existsByPhoneNumber = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (existsByPhoneNumber)
            return new Result("Such client with this phone number already exist", false);
        clientRepository.save(client);
        return new Result("Saved successfully", true);
    }

    //    Get List
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    //    Get by id
    public Client getClientById(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent())
            return new Client();
        return optionalClient.get();
    }

    //    Update
    public Result editClient(Integer id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent())
            return new Result("Such client was not found", false);
        Client editClient = optionalClient.get();
        editClient.setName(client.getName());
        editClient.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(editClient);
        return new Result("Edited successfully", true);
    }

    //     Delete
    public Result deleteClient(Integer id) {
        try {
            clientRepository.deleteById(id);
            return new Result("Client was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
