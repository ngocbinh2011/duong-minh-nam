package com.example.minhnamorder.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@Builder
public class IventoryDto {
    private Product product;
    private Timestamp dateIn;
    private Long firstQuantity;
    private Long totalIn;
    private Long totalOut;
    private Long available;
}
