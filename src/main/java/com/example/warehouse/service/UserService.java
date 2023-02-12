package com.example.warehouse.service;

import com.example.warehouse.entity.Client;
import com.example.warehouse.entity.User1;
import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.payload.Result;
import com.example.warehouse.payload.UserDto;
import com.example.warehouse.repository.UserRepository;
import com.example.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addUser(UserDto userDto) {
        User1 user1 = new User1();

        user1.setFirstName(userDto.getFirstName());
        user1.setLastName(userDto.getLastName());
        user1.setPhoneNumber(userDto.getPhoneNumber());
        user1.setCode(userDto.getCode());
        user1.setPassword(userDto.getPassword());
        user1.setActive(true);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(userDto.getWarehouses());
        if (!optionalWarehouse.isPresent())
            return new Result("Such warehouse was not found", false);
        user1.setWarehouses(Collections.singleton(optionalWarehouse.get()));

        userRepository.save(user1);
        return new Result("Saved successfully", true);
    }

    //    Get List
    public List<User1> getUsers() {
        return userRepository.findAll();
    }

    //    Get by id
    public User1 getUserById(Integer id) {
        Optional<User1> optionalUser1 = userRepository.findById(id);
        if (!optionalUser1.isPresent())
            return new User1();
        return optionalUser1.get();
    }

    //    Update
    public Result editUser(Integer id, UserDto userDto) {
        Optional<User1> optionalUser1 = userRepository.findById(id);
        if (!optionalUser1.isPresent())
            return new Result("Such User was not found", false);
        User1 editUser1 = optionalUser1.get();

        editUser1.setFirstName(userDto.getFirstName());
        editUser1.setLastName(userDto.getLastName());
        editUser1.setPhoneNumber(userDto.getPhoneNumber());
        editUser1.setCode(userDto.getCode());
        editUser1.setPassword(userDto.getPassword());
        editUser1.setActive(true);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(userDto.getWarehouses());
        if (!optionalWarehouse.isPresent())
            return new Result("Such warehouse was not found", false);
        editUser1.setWarehouses(Collections.singleton(optionalWarehouse.get()));

        userRepository.save(editUser1);
        return new Result("Edited successfully", true);
    }

    //     Delete
    public Result deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
            return new Result("User was deleted", true);
        } catch (Exception e) {
            return new Result("Error in deleting", false);
        }
    }
}
