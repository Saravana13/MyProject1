package com.saravana.myproject1.service;

import com.saravana.myproject1.models.Product;

import java.util.List;

public class DBStoreProductService implements ProductService{
    @Override
    public Product getSingleProduct(long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
