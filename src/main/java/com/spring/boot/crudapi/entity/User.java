package com.spring.boot.crudapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String username;
    @Column
    private String lastname;
    @Column
    private String occupation;
    @Column
    private String genter;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public String getGenter() {
        return genter;
    }
    public void setGenter(String genter) {
        this.genter = genter;
    }
    public User(int id, String username, String lastname, String occupation, String genter) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.occupation = occupation;
        this.genter = genter;
    }
    public User() {
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", lastname=" + lastname + ", occupation=" + occupation
                + ", genter=" + genter + "]";
    }


    

}
