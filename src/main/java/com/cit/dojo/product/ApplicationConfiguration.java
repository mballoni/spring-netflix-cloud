package com.cit.dojo.product;

import com.cit.dojo.product.domain.Product;
import com.cit.dojo.product.domain.User;
import com.cit.dojo.product.service.ProductService;
import com.cit.dojo.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);
    }

    @RequestMapping("/")
    public User home() {
        return userService.getUsername("1");
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Product findById(@PathVariable String id) {
        return productService.getProduct(id);
    }

}
