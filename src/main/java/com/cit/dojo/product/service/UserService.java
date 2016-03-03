package com.cit.dojo.product.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import com.cit.dojo.domain.User;

@Service
public class UserService {
    @Autowired
    private LoadBalancerClient loadBalancer;

    public User getUsername() {
        ServiceInstance instance = loadBalancer.choose("user");
        URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));

        return null;
    }
}
