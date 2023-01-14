package com.example.minhnamorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "cost")
    private float cost;

    @JsonIgnore
    @ManyToMany(mappedBy = "productList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ManufacturingOrder> orders = new ArrayList<>();

    public Product() {
    }

    @Builder
    public Product(String code, String name, String description, String category, float cost, List<ManufacturingOrder> orders) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
        this.cost = cost;
        this.orders = orders;
    }
}
