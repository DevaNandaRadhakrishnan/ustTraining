package com.example.customer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerPojo {
    private long cusId;
    private  String cusName;
    private List<OrderPojo> allOrders;
}
