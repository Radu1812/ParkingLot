package com.parking.parkinglot.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class UserGroup {

    private Long id;
    private String username;
    private String UserGroup;

    @Id
    @GeneratedValue

public Long getId() {return id;}
    public void getId(Long id) {this.id = id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getUserGroup() {return UserGroup;}
    public void setUserGroup(String userGroup) {UserGroup = userGroup;}


}
