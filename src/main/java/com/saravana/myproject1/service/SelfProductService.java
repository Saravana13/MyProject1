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

    //get
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
    public Category getSingleCategory(long id) {
        Category c=categoryRepository.findById(id);
        return c;
    }

    // get all
    @Override
    public List<Product> getAllProducts() {
        List<Product> p=productRepository.getAllProducts();
        return p;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> c=categoryRepository.getAllCategories();
        return List.of();
    }

    //create
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
//update
    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Product p= getSingleProduct(id);
        if(product.getTitle()!=null){
            p.setTitle(product.getTitle());
        }
        if(product.getDescription()!=null){
            p.setDescription(product.getDescription());
        }
        if(product.getPrice()!=null){
            p.setPrice(product.getPrice());
        }
        if(product.getImageUrl()!=null){
            p.setImageUrl(product.getImageUrl());
        }
        if(product.getCategory()!=null){
            p.setCategory(product.getCategory());
        }

            productRepository.save(p);

        return p;
    }
//delete
    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }
}
