package com.saravana.myproject1.dto;

import com.saravana.myproject1.models.Category;
import com.saravana.myproject1.models.Product;


public class FakeStoreProductDto {

    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;

    public Product getProduct() {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        Category cat = new Category();
        cat.setTitle(category);
        product.setCategory(cat);

        return product;
    }

    @Override
    public String toString() {
        return "FakeStoreProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
/*id:1,
    title:'...',
    price:'...',
    category:'...',
    description:'...',
    image:'...'*/