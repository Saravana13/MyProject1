package com.saravana.myproject1.repository;

import com.saravana.myproject1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    //save

    //get
    Category findById(long id);

    Category findByTitle(String title);
    Category findByDescription(String description);

    //get all
    @Query(value = "select * from category c",nativeQuery = true)
    List<Category> getAllCategories();

    //update

    //delete
    void deleteCategoriesById(Long id);

}
