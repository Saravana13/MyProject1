package com.saravana.myproject1.service;

import com.saravana.myproject1.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

}
