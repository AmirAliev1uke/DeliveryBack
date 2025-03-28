package com._ukeCompany.delivery_app.service;

import com._ukeCompany.delivery_app.DTO.ProductRequestDTO;
import com._ukeCompany.delivery_app.Mappers.ProductMapper;
import com._ukeCompany.delivery_app.DTO.ProductDTO;
import com._ukeCompany.delivery_app.DTO.ProductResponceDTO;
import com._ukeCompany.delivery_app.entity.Category;
import com._ukeCompany.delivery_app.entity.Product;
import com._ukeCompany.delivery_app.repository.CategoryRepository;
import com._ukeCompany.delivery_app.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public List<ProductResponceDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponceDTO> productResponceDTOS = productMapper.toProductResponceDTOList(products);
        return productResponceDTOS;
    }

    public ProductResponceDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return productMapper.toProductResponceDTO(product);
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

    public List<ProductResponceDTO> getProductByCategoryName(Long categoryId) {
        List <Product> products = productRepository.findByCategoryIdAndIsDeletedFalse(categoryId);
        List <ProductResponceDTO> productDTOS = productMapper.toProductResponceDTOList(products);
        return productDTOS;
    }

    public ProductResponceDTO updateProduct(ProductRequestDTO productRequestDTO) {
        Long id = productRequestDTO.getId();
        Product product = productRepository.findById(id).orElse(null);
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setImageurl(productRequestDTO.getImageurl());
        productRepository.save(product);
        return productMapper.toProductResponceDTO(product);
    }
}
