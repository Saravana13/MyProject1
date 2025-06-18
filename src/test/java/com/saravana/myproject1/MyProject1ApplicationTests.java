package com.saravana.myproject1;

import com.saravana.myproject1.models.Category;
import com.saravana.myproject1.models.Product;
import com.saravana.myproject1.repository.CategoryRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;

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

    @Test
    void fetchTypeTest(){
        System.out.println("Going to fetch type test");
        Category cat= categoryRepository.findById(1L);
        System.out.println("fetched Category");
//        for(Product p:cat.getProductList()){
//            System.out.println(p.getTitle());
//        }
        System.out.println("fetched Category Title");
    }

}
