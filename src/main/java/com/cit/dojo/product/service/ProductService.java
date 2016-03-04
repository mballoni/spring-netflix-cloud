package com.cit.dojo.product.service;

import com.cit.dojo.product.domain.Product;
import org.springframework.stereotype.Component;

/**
 * Created by dayani on 04/03/16.
 */
@Component
public class ProductService {
    public Product getProduct(String id) {
        return new Product(id, "geladeira");
    }
}
