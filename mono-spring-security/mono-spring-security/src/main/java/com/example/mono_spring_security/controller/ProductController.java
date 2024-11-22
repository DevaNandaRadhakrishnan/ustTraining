package com.example.mono_spring_security.controller;

import com.example.mono_spring_security.entity.Product;
import com.example.mono_spring_security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/products/{pid}")
    public Optional<Product> getAProduct(@PathVariable long id){
        return  productService.getAProduct(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product newProd){
        return productService.addProduct(newProd);
    }
}
