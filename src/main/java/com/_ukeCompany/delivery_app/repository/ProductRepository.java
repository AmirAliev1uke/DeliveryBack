package com._ukeCompany.delivery_app.repository;

import com._ukeCompany.delivery_app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByCategoryIdAndIsDeletedFalse(Long categoryId);
    List<Product> findAllByIsDeletedFalse();
}
