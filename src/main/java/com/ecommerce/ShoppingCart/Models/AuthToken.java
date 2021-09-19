package com.ecommerce.ShoppingCart.Models;

import java.util.Date;
import java.util.UUID;

public class AuthToken {

    private Integer id;
    private String token;
    private Date createdDate;

    private User user;

    public AuthToken(User user) {
        this.user = user;
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();
    }

    public AuthToken(Integer id, String Token, Date createdDate, User user) {
        this.id = id;
        this.token = Token;
        this.createdDate = createdDate;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String Token) {
        this.token = Token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
