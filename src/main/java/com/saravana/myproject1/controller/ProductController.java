package com.saravana.myproject1.controller;

import com.saravana.myproject1.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    //CRUD APIs around product

    //To create Product
  //  @RequestMapping(value ="/products", method=RequestMethod.POST)
    @PostMapping("/products") //same as above line
    public void createProduct(Product product) {


    }
    //To get Product using id

    public Product getProductByID(Long id) {
        return null;
    }
    //To update Product
    public void updateProduct(Product product) {

    }
    //To delete Product
    public void deleteProduct(Long id) {

    }
}
