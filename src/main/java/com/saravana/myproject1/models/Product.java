package com.saravana.myproject1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Product extends BaseModel {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    @ManyToOne
    private Category category;
}
//{
//        "id": 21,
//        "title": "apple phone",
//        "description": "This is description",
//        "price": 109.95,
//        "imageUrl": null,
//        "category": {
//        "id": null,
//        "title": "apple",
//        "description": null
//        }
//        }