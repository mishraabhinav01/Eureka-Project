package com.ecommerce.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.product.dto.ProductDTO;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    // CREATE
    @PostMapping("/add")
    public Product addProduct(@RequestBody @Validated ProductDTO dto) {
        return service.addProduct(dto);
    }

    // GET ALL ✅ IMPORTANT
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // UPDATE
    @PutMapping("/update")
    public Product updateProduct(@RequestBody ProductDTO dto) {
        return service.updateProduct(dto);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
