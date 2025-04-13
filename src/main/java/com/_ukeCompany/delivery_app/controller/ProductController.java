package com._ukeCompany.delivery_app.controller;

import com._ukeCompany.delivery_app.DTO.*;
import com._ukeCompany.delivery_app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    //TODO Надо пагинацию сделать когда сделаю на ui отображение по страницам
    @GetMapping
    public List<ProductResponceDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponceDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductResponceDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @PostMapping("/update")
    public ProductResponceDTO updateProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return productService.updateProduct(productRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping("/byCategoryId")
    public List <ProductResponceDTO> getProductByCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        return productService.getProductByCategoryName(categoryRequestDTO.getId());
    }
}
