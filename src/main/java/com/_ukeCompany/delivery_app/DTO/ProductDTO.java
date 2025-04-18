package com._ukeCompany.delivery_app.DTO;

import com._ukeCompany.delivery_app.entity.Category;
import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private String description;
    private String imageurl;
    private Long categoryId;
}
