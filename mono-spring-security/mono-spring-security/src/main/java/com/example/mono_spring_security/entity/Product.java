package com.example.mono_spring_security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="product_details")
public class Product {
    @Id
    @Column(name="prod_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long prodId;

    @Column(name="prod_name")
    private String prodName;
}
