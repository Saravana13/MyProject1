package com.saravana.myproject1.repository;

import com.saravana.myproject1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    //save

    //get
    Category findByTitle(String title);
    Category findByDescription(String description);

    //get all

    //update

    //delete


}
