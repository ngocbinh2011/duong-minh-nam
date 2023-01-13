package com.example.duongminhnam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
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
}
