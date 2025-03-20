package com._ukeCompany.delivery_app.controller;

import com._ukeCompany.delivery_app.DTO.CategoryDTO;
import com._ukeCompany.delivery_app.DTO.ProductDTO;
import com._ukeCompany.delivery_app.DTO.ProductResponceDTO;
import com._ukeCompany.delivery_app.entity.Product;
import com._ukeCompany.delivery_app.service.ProductService;
import io.minio.errors.MinioException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductResponceDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @PostMapping("/update")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/byCategoryId")
    public List <ProductDTO> getProductByCategory(@RequestBody CategoryDTO categoryDTO) {
        return productService.getProductByCategoryName(categoryDTO.getId());
    }
}
