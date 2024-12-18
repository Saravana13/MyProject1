package com.saravana.myproject1.controller;

import com.saravana.myproject1.dto.ErrorDto;
import com.saravana.myproject1.exceptions.ProductNotFoundException;
import com.saravana.myproject1.models.Product;
import com.saravana.myproject1.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //CRUD APIs around product

    //To create Product
  //  @RequestMapping(value ="/products", method=RequestMethod.POST)
    @PostMapping("/products") //same as above line
    public ResponseEntity<Product>  createProduct(@RequestBody Product product) {
        System.out.println("Creating a new product");
        Product p=productService.createProduct(
                product.getId(), product.getTitle(),
                product.getDescription(), product.getPrice(),product.getImageUrl(),
                product.getCategory().getTitle().toString());
        ResponseEntity<Product> response=new ResponseEntity<>(
                p, HttpStatus.OK
        );
        System.out.println("Product created, sending information");
        return response;
    }
    //To get Product using id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable("id") Long id) throws ProductNotFoundException {

        Product p=productService.getSingleProduct(id);
        ResponseEntity<Product> response=new ResponseEntity<>(
                p, HttpStatus.OK
        );

        return response;
    }
    //To update Product
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable Long id) throws ProductNotFoundException {
        System.out.println("Updating a product");
        Product p=productService.updateProduct(id,product);
        ResponseEntity<Product> response=new ResponseEntity<>(
                p, HttpStatus.OK
        );
        System.out.println("Product updated, sending information");
        return response;
    }
    //To delete Product
    @RequestMapping(value ="/products/{id}" ,method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") Long id) {
        System.out.println("Deleting a product");
        productService.deleteProduct(id);
        System.out.println("Product deleted, sending information");
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        ResponseEntity<ErrorDto> r=new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        return r;
    }
}
