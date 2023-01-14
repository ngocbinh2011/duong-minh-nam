package com.example.minhnamorder.controller;

import com.example.minhnamorder.model.Inventory;
import com.example.minhnamorder.model.IventoryDto;
import com.example.minhnamorder.repository.InventoryRepository;
import com.example.minhnamorder.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/inventories")
    public ResponseEntity<?> getEntitys(@RequestParam(name = "start", required = false) String dateStart,
                                        @RequestParam(name = "start", required = false) String dateEnd){
        List<Inventory> inventoryList = null;
        if(dateStart == null){
            inventoryList = inventoryRepository.findAll();
        } else{
            inventoryList = inventoryRepository.findAll();
        }

        return ResponseEntity.ok(
                inventoryList.stream().map(inventory ->
                     IventoryDto.builder()
                            .product(productRepository.findById(inventory.getProductCode()).orElse(null))
                            .dateIn(inventory.getDateIn())
                            .firstQuantity(inventory.getFirstQuantity())
                            .totalIn(inventory.getTotalIn())
                            .totalOut(inventory.getTotalOut())
                            .available(inventory.getAvailable())
                            .build()
                ).collect(Collectors.toList())
        );
    }
}
