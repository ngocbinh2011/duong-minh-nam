package com.example.minhnamorder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
public class ProductOrderDto{
    private String code;
    private String name;
    private String description;
    private String category;
    private float cost;

    @JsonProperty("qty")
    private int quantity;

    public static ProductOrderDto fromProduct(Product product, int quantity){
        return ProductOrderDto.builder()
                .code(product.getCode())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .cost(product.getCost())
                .quantity(quantity)
                .build();
    }

    public Product toProduct(){
        return Product.builder()
                .code(code)
                .name(name)
                .description(description)
                .category(category)
                .cost(cost)
                .build();
    }
}