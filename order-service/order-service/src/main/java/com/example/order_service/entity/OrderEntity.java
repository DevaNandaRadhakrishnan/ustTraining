package com.example.order_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "order_details")
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    private long empId;

    @Column(name = "customer_id")
    private long cusId;

    @Column(name = "order_price")
    private long price;
}
