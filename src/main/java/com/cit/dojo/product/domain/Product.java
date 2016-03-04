package com.cit.dojo.product.domain;

/**
 * Created by dayani on 04/03/16.
 */
public class Product {
    private String ean;
    private String description;

    public Product(String ean, String description) {
        this.ean = ean;
        this.description = description;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
