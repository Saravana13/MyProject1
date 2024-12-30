package com.saravana.myproject1.repository;

import com.saravana.myproject1.models.Product;
import com.saravana.myproject1.repository.projections.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //save // update
    Product save(Product product);

    //get
    Product findByDescription(String description);
    Product findByTitle(String title);


    //get all
    @Query(value = "select * from product p",nativeQuery = true)
    List<Product> getAllProducts();

    //Implementing HQL
    @Query("SELECT p FROM Product p where p.category.id =:id")
    List<Product> getProductByCategoryId(@Param("id") Long id);

    @Query("SELECT p.id,p.title FROM Product p where p.category.id =:id")
    List<ProductProjection> getProductByCategoryIdUsingProjections(@Param("id") Long id);

    //Implementing Native query
    @Query(value = "select * from product p where p.category.id =:id",nativeQuery = true)
    List<Product> getProductByCategoryIdUsingNative(@Param("id") Long id);

    //delete
    void deleteProductById(Long id);
    void deleteProductByCategoryId(Long id);
    void deleteProductByTitle(String title);
}
