package com.example.warehouse.repository;

import com.example.warehouse.entity.Client;
import com.example.warehouse.service.ClientService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
