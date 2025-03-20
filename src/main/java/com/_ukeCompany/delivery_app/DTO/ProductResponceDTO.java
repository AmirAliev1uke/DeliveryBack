package com._ukeCompany.delivery_app.DTO;

import lombok.Data;

@Data
public class ProductResponceDTO {
    private Long id;
    private String name;
    private double price;
    private String description;
    private String imageurl;
}
