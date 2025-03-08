package com._ukeCompany.delivery_app.repository;

import com._ukeCompany.delivery_app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
