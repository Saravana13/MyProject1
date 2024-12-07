package com.saravana.myproject1.controller;

import com.saravana.myproject1.models.Product;
import com.saravana.myproject1.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //CRUD APIs around product

    //To create Product
  //  @RequestMapping(value ="/products", method=RequestMethod.POST)
    @PostMapping("/products") //same as above line
    public void createProduct(Product product) {


    }
    //To get Product using id
    @GetMapping("/products/{id}")
    public Product getProductByID(@PathVariable("id") Long id) {
        productService.getSingleProduct(id);
        return null;
    }
    //To update Product
    public void updateProduct(Product product) {

    }
    //To delete Product
    public void deleteProduct(Long id) {

    }
}
