package com.spring.boot.crudapi.controller;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.crudapi.entity.User;
import com.spring.boot.crudapi.repository.userRepo;

@RestController
public class homeController {

    @Autowired
    private userRepo repo;

    @GetMapping("/api/crud/users")
    private ResponseEntity getAllUsers() {
        java.util.List<User> user = new ArrayList<>();
        try {
            user.add((User) repo.findAll());
            if (user.isEmpty()) {
              return   ResponseEntity.ok().body("not found any user");
            } else {
               return  ResponseEntity.ok().body(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Server Error " + e);
        }

    }
}
