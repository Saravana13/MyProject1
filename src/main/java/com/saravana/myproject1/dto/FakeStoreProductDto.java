package com.saravana.myproject1.dto;

import com.saravana.myproject1.models.Category;
import com.saravana.myproject1.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductDto {

    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;

    public Product getProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);
        Category cat = new Category();
        cat.setTitle(category);
        return product;
    }
}
/*id:1,
    title:'...',
    price:'...',
    category:'...',
    description:'...',
    image:'...'*/