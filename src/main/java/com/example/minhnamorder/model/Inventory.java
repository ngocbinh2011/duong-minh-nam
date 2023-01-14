package com.example.minhnamorder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "inventory")
@Data
public class Inventory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productCode")
    private String productCode;

    @Column(name = "date_in")
    private Timestamp dateIn;

    @Column(name = "firstQuantity")
    private Long firstQuantity;

    @Column(name = "totalIn")
    private Long totalIn;

    @Column(name = "totalOut")
    private Long totalOut;

    @Column(name = "available")
    private Long available;
}
