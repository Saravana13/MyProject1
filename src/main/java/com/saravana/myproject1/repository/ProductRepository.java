package com.saravana.myproject1.repository;

import com.saravana.myproject1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //save
    Product save(Product product);

    //get
    Product findByDescription(String description);
    Product findByTitle(String title);


    //get all

    // update

    //delete
}
