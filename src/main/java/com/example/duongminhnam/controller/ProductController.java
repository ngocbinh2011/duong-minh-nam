package com.example.duongminhnam.controller;

import com.example.duongminhnam.model.Product;
import com.example.duongminhnam.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<?> getEntity(@PathVariable(value = "id") String id){
        return ResponseEntity.ok(productRepository.findById(id).orElse(null));
    }

    @GetMapping(value = "/products")
    public ResponseEntity<?> getEntitys(){
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PostMapping(value = "/product")
    public ResponseEntity<?> postEntity(@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.ok("OK");
    }

    @GetMapping(path = "/product/search")
    public ResponseEntity<?> getEntityByName(@RequestParam(name = "query") String name){
        return ResponseEntity.ok(productRepository.findByNameLike(name));
    }


}
