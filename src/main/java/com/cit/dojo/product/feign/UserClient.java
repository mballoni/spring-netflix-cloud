package com.cit.dojo.product.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cit.dojo.product.domain.User;

@FeignClient("users")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}", consumes = "application/json")
    User getUser(@PathVariable("id") String id);
}
