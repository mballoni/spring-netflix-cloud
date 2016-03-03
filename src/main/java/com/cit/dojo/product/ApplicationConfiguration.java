package com.cit.dojo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cit.dojo.domain.User;
import com.cit.dojo.product.service.UserService;

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@RibbonClient(name = "product")
@EnableFeignClients
@RestController
@ComponentScan
public class ApplicationConfiguration {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public User home() {
        return userService.getUsername("1");
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);
    }

}
