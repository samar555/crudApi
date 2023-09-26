package com.spring.boot.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.crudapi.entity.User;



@Repository
public interface userRepo extends JpaRepository<User,Integer> {

    
    public User  findById(int id);
}
