package com.saravana.myproject1.service;

import com.saravana.myproject1.exceptions.ProductNotFoundException;
import com.saravana.myproject1.models.Category;
import com.saravana.myproject1.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id) throws ProductNotFoundException;

    Category getSingleCategory(long id);

    List<Product> getAllProducts();

    List<Category> getAllCategories();

    Product createProduct(Long id, String name, String description,Double price,String imageUrl,String category);

    Product updateProduct(Long id,Product product ) throws ProductNotFoundException;

    void deleteProduct(long id);

    void deleteCategory(long id);

}
