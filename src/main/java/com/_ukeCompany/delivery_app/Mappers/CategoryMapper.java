package com._ukeCompany.delivery_app.Mappers;

import com._ukeCompany.delivery_app.DTO.CategoryDTO;
import com._ukeCompany.delivery_app.DTO.CategoryRequestDTO;
import com._ukeCompany.delivery_app.DTO.CategoryResponseDTO;
import com._ukeCompany.delivery_app.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDto(Category category);

    List<CategoryDTO> toDtoList(List<Category> categories);

    CategoryResponseDTO toResponseDto(Category category);

    List<CategoryResponseDTO> toResponseDtoList(List<Category> categories);

    Category toCategory(CategoryRequestDTO categoryRequestDTO);
}
