package com._ukeCompany.delivery_app.Mappers;

import com._ukeCompany.delivery_app.DTO.ProductDTO;
import com._ukeCompany.delivery_app.DTO.ProductRequestDTO;
import com._ukeCompany.delivery_app.DTO.ProductResponceDTO;
import com._ukeCompany.delivery_app.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product product);
    List<ProductDTO> toDtoList(List<Product> products);
    Product toProduct(ProductDTO productDTO);
    List<Product> toProductList(List<ProductDTO> productDTOs);
    ProductResponceDTO toProductResponceDTO(Product product);
    List<ProductResponceDTO> toProductResponceDTOList(List<Product> products);
}
