package com._ukeCompany.delivery_app.repository;

import com._ukeCompany.delivery_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
