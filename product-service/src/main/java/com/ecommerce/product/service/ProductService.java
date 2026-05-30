package com.ecommerce.product.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.dto.ProductDTO;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    // CREATE
    public Product addProduct(ProductDTO dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return repo.save(product);
    }

    // GET ALL
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // UPDATE
    public Product updateProduct(ProductDTO dto) {
        Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return repo.save(product);
    }

    // DELETE
    public String deleteProduct(int id) {
        repo.deleteById(id);
        return "Product deleted";
    }
}