package com.saravana.myproject1.service;

import com.saravana.myproject1.exceptions.ProductNotFoundException;
import com.saravana.myproject1.models.Category;
import com.saravana.myproject1.models.Product;
import com.saravana.myproject1.repository.CategoryRepository;
import com.saravana.myproject1.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "selfProductService")

public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }



    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> p=productRepository.findById(id);
        if(p.isPresent()){
            return p.get();
        }else{
            throw new ProductNotFoundException("Product not found");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Long id, String name, String description, Double price, String imageUrl, String category) {
        Product p=new Product();

        Category currentCategory=categoryRepository.findByTitle(category);
        if(currentCategory==null){
            //need to create the category
            Category newCategory=new Category();
            newCategory.setTitle(category);
            categoryRepository.save(newCategory);
            p.setCategory(newCategory);
        }else{
            //category already present
            p.setCategory(currentCategory);
        }

        p.setTitle(name);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageUrl(imageUrl);


        Product savedProduct=productRepository.save(p);

        return savedProduct;
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }
}
