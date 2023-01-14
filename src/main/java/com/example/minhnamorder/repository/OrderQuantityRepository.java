package com.example.minhnamorder.repository;

import com.example.minhnamorder.model.OrderQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderQuantityRepository extends JpaRepository<OrderQuantity, Long> {
    List<OrderQuantity> findByOrderIDAndProductCode(Long orderID, String productCode);
}
