package com._ukeCompany.delivery_app.service;

import com._ukeCompany.delivery_app.DTO.Mappers.ProductMapper;
import com._ukeCompany.delivery_app.DTO.ProductDTO;
import com._ukeCompany.delivery_app.DTO.ProductResponceDTO;
import com._ukeCompany.delivery_app.entity.Category;
import com._ukeCompany.delivery_app.entity.Product;
import com._ukeCompany.delivery_app.repository.CategoryRepository;
import com._ukeCompany.delivery_app.repository.ProductRepository;
import io.minio.errors.MinioException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;
    private final MinioService minioService;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = productMapper.toDtoList(products);
        return productDTOs;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductResponceDTO saveProduct(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);
        product.setCategory(category);
        productRepository.save(product);
        return productMapper.toProductResponceDTO(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getProductByCategoryName(Long categoryId) {
        List <Product> products = productRepository.findByCategoryId(categoryId);
        List <ProductDTO> productDTOS = productMapper.toDtoList(products);
        return productDTOS;
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Long id = productDTO.getId();
        Product product = productRepository.findById(id).orElse(null);
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageurl(productDTO.getImageurl());
        productRepository.save(product);
        return productMapper.toDto(product);
    }
}
