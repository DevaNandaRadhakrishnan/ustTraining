package com.example.order_service.controller;

import com.example.order_service.entity.OrderEntity;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<OrderEntity> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/orders/customer/{oid}")
    public List<OrderEntity> getOrderByCusId(long cusId){
        return orderRepository.findByCusId(cusId);
    }

    @PostMapping("/orders")
    public OrderEntity addOrder(@RequestBody OrderEntity newOrder) {
        return orderRepository.saveAndFlush(newOrder);
    }
}
