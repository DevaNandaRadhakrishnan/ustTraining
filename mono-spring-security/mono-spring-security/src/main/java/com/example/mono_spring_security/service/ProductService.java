package com.example.mono_spring_security.service;

import com.example.mono_spring_security.entity.Product;
import com.example.mono_spring_security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Optional<Product> getAProduct(long prodId){
        return productRepository.findById(prodId);
    }

    public Product addProduct(Product newProduct){
        return productRepository.saveAndFlush(newProduct);
    }
}
