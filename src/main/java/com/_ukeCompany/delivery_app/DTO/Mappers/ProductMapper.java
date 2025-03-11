package com._ukeCompany.delivery_app.DTO.Mappers;

import com._ukeCompany.delivery_app.DTO.ProductDTO;
import com._ukeCompany.delivery_app.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product product);
    List<ProductDTO> toDtoList(List<Product> products);
}
