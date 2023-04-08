package com.eventmanager.controllers;

import com.eventmanager.models.User;
import com.eventmanager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {

    UserRepository repository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return repository.findAll();
    }
}
