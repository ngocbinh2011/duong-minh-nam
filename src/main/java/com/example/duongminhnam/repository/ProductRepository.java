package com.example.duongminhnam.repository;

import com.example.duongminhnam.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("select e from Product e where e.name like %:name%")
    List<Product> findByNameLike(String name);
}
