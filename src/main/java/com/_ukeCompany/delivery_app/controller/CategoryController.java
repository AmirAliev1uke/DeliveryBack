package com._ukeCompany.delivery_app.controller;

import com._ukeCompany.delivery_app.DTO.CategoryDTO;
import com._ukeCompany.delivery_app.DTO.CategoryRequestDTO;
import com._ukeCompany.delivery_app.DTO.CategoryResponseDTO;
import com._ukeCompany.delivery_app.entity.Category;
import com._ukeCompany.delivery_app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/create")
    public CategoryResponseDTO createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        return categoryService.saveCategory(categoryRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @PostMapping("/update/{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO categoryRequestDTO) {
        categoryService.updateCategory(id, categoryRequestDTO);
    }

}
