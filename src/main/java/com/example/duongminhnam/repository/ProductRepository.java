package com.example.duongminhnam.repository;

import com.example.duongminhnam.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByNameLike(String name);
}
