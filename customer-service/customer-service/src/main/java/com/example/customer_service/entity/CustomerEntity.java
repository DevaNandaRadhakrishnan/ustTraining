package com.example.customer_service.entity;

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
@Table(name = "customer_details")

public class CustomerEntity {

    @Id
    @Column(name = "cus_id")
    private long cusId;

    @Column(name = "cus_name")
    private String cusName;

}
