package com.example.minhnamorder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Entity
@Table(name = "order_quantity")
public class OrderQuantity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orderID")
    private Long orderID;

    @Column(name = "productCode")
    private String productCode;

    @Column(name = "quantity")
    private int quantity;

}
