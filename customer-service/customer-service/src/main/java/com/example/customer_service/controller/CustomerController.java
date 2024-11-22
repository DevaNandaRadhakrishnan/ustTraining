package com.example.customer_service.controller;

import com.example.customer_service.entity.CustomerEntity;
import com.example.customer_service.model.CustomerPojo;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerPojo> getAllCustomers(){
        List<CustomerEntity> allCus = customerRepository.findAll();
        List<CustomerPojo> allCusPojo = new ArrayList<>();
        allCus.forEach(cusEntity -> {
            CustomerPojo cusPojo = new CustomerPojo();
            BeanUtils.copyProperties(cusEntity, cusPojo);
            allCusPojo.add(cusPojo);
        });
        return allCusPojo;
    }

    public CustomerPojo getCustomer(long cusId) {
        Optional<CustomerEntity> fetchcusEntity = customerRepository.findById(cusId);
        CustomerPojo cusPojo = null;
        if (fetchcusEntity.isPresent()) {
            cusPojo = new CustomerPojo();
            BeanUtils.copyProperties(fetchcusEntity.get(), cusPojo);
        }
        return cusPojo;
    }

    public CustomerPojo addCustomer(CustomerPojo newCustomerPojo) {
        CustomerEntity cusEntity = new CustomerEntity();
        BeanUtils.copyProperties(newCustomerPojo, cusEntity);
        customerRepository.saveAndFlush(cusEntity);
        return newCustomerPojo;
    }

}
