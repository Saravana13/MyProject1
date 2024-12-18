package com.saravana.myproject1.service;

import com.saravana.myproject1.dto.FakeStoreProductDto;
import com.saravana.myproject1.exceptions.ProductNotFoundException;
import com.saravana.myproject1.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    //Inside this, fake store third party going to be added

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getSingleProduct(long id) throws ProductNotFoundException {
        System.out.println("getSingleProduct");
        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class);
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product not found");
        }
        Product p=fakeStoreProductDto.getProduct();

        if(p == null){
            throw new ProductNotFoundException("Product not found");
        }
        //System.out.println(fakeStoreProductDto.toString());

        return p;
    }


    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Long id, String name, String description, Double price,String url, String category) {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(name);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(url);
        fakeStoreProductDto.setCategory(category);

        FakeStoreProductDto response=restTemplate.postForObject
                ("https://fakestoreapi.com/products",
                        fakeStoreProductDto,FakeStoreProductDto.class);

        return response.getProduct();
    }

    @Override
    public Product updateProduct(Long id,Product product) throws ProductNotFoundException {
        Product p=getSingleProduct(id);
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        if(product.getTitle()!=null){
            fakeStoreProductDto.setTitle(product.getTitle());
        }else{
            fakeStoreProductDto.setTitle(p.getTitle());
        }
        if(product.getDescription()!=null){
            fakeStoreProductDto.setDescription(product.getDescription());
        }else{
            fakeStoreProductDto.setDescription(p.getDescription());
        }
        if(product.getPrice()!=null){
            fakeStoreProductDto.setPrice(product.getPrice());
        }else{
            fakeStoreProductDto.setPrice(p.getPrice());
        }
        if(product.getImageUrl()!=null){
            fakeStoreProductDto.setImage(product.getImageUrl());
        }else{
            fakeStoreProductDto.setImage(p.getImageUrl());
        }
        if(product.getCategory()!=null){
            fakeStoreProductDto.setCategory(product.getCategory().getTitle());
        }else{
            fakeStoreProductDto.setCategory(p.getCategory().getTitle());
        }
        HttpEntity<FakeStoreProductDto> responseEntity=new HttpEntity<>(fakeStoreProductDto);
        responseEntity=restTemplate.exchange("https://fakestoreapi.com/products/"+id, HttpMethod.PUT,
                responseEntity,FakeStoreProductDto.class);

        return fakeStoreProductDto.getProduct();
    }

    @Override
    public void deleteProduct(long id){
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        System.out.println("Product deleted");
    }

}
