package com._ukeCompany.delivery_app.service;

import com._ukeCompany.delivery_app.DTO.CategoryDTO;
import com._ukeCompany.delivery_app.DTO.Mappers.ProductMapper;
import com._ukeCompany.delivery_app.DTO.ProductDTO;
import com._ukeCompany.delivery_app.entity.Product;
import com._ukeCompany.delivery_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getProductByCategoryName(Long categoryId) {
        List <Product> products = productRepository.findByCategoryId(categoryId);
        List <ProductDTO> productDTOS = productMapper.toDtoList(products);
        return productDTOS;
    }
}
