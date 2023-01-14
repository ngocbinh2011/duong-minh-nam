package com.example.minhnamorder.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class OrderDto {
    private Long id;
    private Timestamp date;
    private String clientName;
    private Timestamp deliverDate;
    private Timestamp dateStart;
    private Timestamp dateExpect;
    private List<ProductOrderDto> productList = new ArrayList<>();

    public ManufacturingOrder toOrder(){
        return ManufacturingOrder.builder()
                .id(id)
                .date(date)
                .clientName(clientName)
                .deliverDate(deliverDate)
                .dateStart(dateStart)
                .dateExpect(dateExpect)
                .productList(productList.stream().map(ProductOrderDto::toProduct).collect(Collectors.toList()))
                .build();
    }
}

