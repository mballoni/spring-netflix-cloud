package com.cit.dojo.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cit.dojo.domain.User;
import com.cit.dojo.product.feign.UserClient;

@Service
public class UserService {

    @Autowired
    UserClient userClient;
    
    public User getUsername(String id) {
        return userClient.getUser(id);
    }
}
