package com.example.spring_bill_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="bill_details", uniqueConstraints = @UniqueConstraint(columnNames = {"customer_id", "product_id"}))
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_no")
    private long billNo;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "quantity")
    private int qty;

    @Column(name = "price")
    private double price;
}
