package com.spring.boot.crudapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.crudapi.entity.User;
import com.spring.boot.crudapi.repository.userRepo;

@RestController
@RequestMapping(path = "/api/crud")
public class homeController {

    @Autowired
    private userRepo repo;

    @GetMapping("/users")
    private ResponseEntity getAllUsers() {
        java.util.List<User> user = new ArrayList<>();
        try {
            user =repo.findAll();
            if (user.isEmpty()) {
                return ResponseEntity.ok().body("not found any user");
            } else {
                return ResponseEntity.ok().body(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Server Error " + e);
        }

    }

    @PostMapping("/adduser")
    private ResponseEntity addUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok().body(repo.save(user));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("internal server error " + e);
        }
    }

    @PostMapping("/user")
    private ResponseEntity getuser(@RequestParam int id) {
        try {
            User user = repo.findById(id);
            if (user == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok().body(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping("/updateUser")
    private ResponseEntity updateUser(@RequestParam int id, @RequestBody User user) {

        try {
            User previousUser = repo.findById(id);
            if (previousUser == null) {
                return ResponseEntity.notFound().build();
            } else {
                previousUser.setGender(user.getGender());
                previousUser.setLastname(user.getLastname());
                previousUser.setOccupation(user.getOccupation());
                previousUser.setUsername(user.getUsername());
                return ResponseEntity.ok().body(repo.save(previousUser));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Bad Request " + e);
        }
    }
    @PostMapping("/delete-user")
    private ResponseEntity deleteUser(@RequestParam int id){
        
        try{
            User user=repo.findById(id);
            if(user==null){
              return   ResponseEntity.notFound().build();
            }else{
                repo.delete(user);
              return ResponseEntity.ok().body("successFully Deleted "+user);
            }
       


        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
