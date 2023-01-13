package com.example.duongminhnam.controller;

import com.example.duongminhnam.model.ManufacturingOrder;
import com.example.duongminhnam.model.Product;
import com.example.duongminhnam.repository.ManufracturingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class ManufacturingOrderController {
    @Autowired
    private ManufracturingOrderRepository manufracturingOrderRepository;

    @GetMapping(value = "/order/{id}")
    public ResponseEntity<?> getEntity(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(manufracturingOrderRepository.findById(id).orElse(null));
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<?> getEntitys(){
        return ResponseEntity.ok(manufracturingOrderRepository.findAll());
    }

    @PostMapping(value = "/order")
    public ResponseEntity<?> postEntity(@RequestBody ManufacturingOrder order){
        manufracturingOrderRepository.save(order);
        return ResponseEntity.ok("OK");
    }
}
