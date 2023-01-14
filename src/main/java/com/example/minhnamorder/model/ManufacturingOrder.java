package com.example.minhnamorder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Entity
@Table(name = "manufacturing_order")
public class ManufacturingOrder {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_mo")
    private Timestamp date;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "date_deliver")
    private Timestamp deliverDate;

    @Column(name = "date_start")
    private Timestamp dateStart;

    @Column(name = "date_expect")
    private Timestamp dateExpect;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_order",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "code"))
    private List<Product> productList = new ArrayList<>();

    public ManufacturingOrder() {
    }

    @Builder
    public ManufacturingOrder(Long id, Timestamp date, String clientName, Timestamp deliverDate, Timestamp dateStart, Timestamp dateExpect, List<Product> productList) {
        this.id = id;
        this.date = date;
        this.clientName = clientName;
        this.deliverDate = deliverDate;
        this.dateStart = dateStart;
        this.dateExpect = dateExpect;
        this.productList = productList;
    }
}
