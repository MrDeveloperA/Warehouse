package com.example.warehouse.controller;

import com.example.warehouse.entity.Client;
import com.example.warehouse.entity.User1;
import com.example.warehouse.payload.Result;
import com.example.warehouse.payload.UserDto;
import com.example.warehouse.service.ClientService;
import com.example.warehouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //    Add
    @PostMapping
    public Result addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    //    Get
    @GetMapping
    public List<User1> getUser1() {
        return userService.getUsers();
    }

    //    Get by id
    @GetMapping("/{id}")
    public User1 getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    //    Edit
    @PutMapping("/{id}")
    public Result editUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return userService.editUser(id, userDto);
    }

    //    Delete
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}
