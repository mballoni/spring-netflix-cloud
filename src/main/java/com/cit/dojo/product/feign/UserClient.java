package com.cit.dojo.product.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cit.dojo.domain.User;

@FeignClient("user")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    User getUser(@PathVariable String id);
}
