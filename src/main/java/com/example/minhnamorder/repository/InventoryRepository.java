package com.example.minhnamorder.repository;

import com.example.minhnamorder.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByDateInBetween(Timestamp from, Timestamp to);
}
