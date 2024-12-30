package com.saravana.myproject1;

import com.saravana.myproject1.models.Product;
import com.saravana.myproject1.repository.ProductRepository;
import com.saravana.myproject1.repository.projections.ProductProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyProject1ApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testQueries(){
//        List<Product> allProducts=productRepository.getProductByCategoryId(1L);
//
//        for(Product p:allProducts){
//            System.out.println(p.getTitle());
//        }
        List<ProductProjection> productProjection=productRepository.getProductByCategoryIdUsingProjections(1L);
        for(ProductProjection p:productProjection){
           System.out.println(p.getTitle());
       }
    }

}
