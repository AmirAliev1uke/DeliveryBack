package com._ukeCompany.delivery_app.service;

import com._ukeCompany.delivery_app.DTO.CategoryDTO;
import com._ukeCompany.delivery_app.DTO.CategoryRequestDTO;
import com._ukeCompany.delivery_app.DTO.CategoryResponseDTO;
import com._ukeCompany.delivery_app.Mappers.CategoryMapper;
import com._ukeCompany.delivery_app.entity.Category;
import com._ukeCompany.delivery_app.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS = categoryMapper.toResponseDtoList(categories);
        return categoryResponseDTOS;
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return categoryMapper.toResponseDto(category);
    }

    public CategoryResponseDTO saveCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryMapper.toCategory(categoryRequestDTO);
        categoryRepository.save(category);
        return categoryMapper.toResponseDto(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
