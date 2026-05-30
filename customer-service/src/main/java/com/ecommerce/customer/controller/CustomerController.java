package com.ecommerce.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.customer.dto.CustomerDTO;
import com.ecommerce.customer.entity.Customer;
import com.ecommerce.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    // CREATE
    @PostMapping("/add")
    public Customer addCustomer(@RequestBody @Validated CustomerDTO dto) {
        return service.addCustomer(dto);
    }

    // GET ALL
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

@GetMapping("/products")
public Object getProducts() {
    return service.getAllProducts();
}


    // UPDATE
    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody CustomerDTO dto) {
        return service.updateCustomer(dto);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteCustomer(id);
    }
}
