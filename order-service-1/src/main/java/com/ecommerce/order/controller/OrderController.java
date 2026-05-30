package com.ecommerce.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.order.dto.OrderDTO;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    // CREATE
    @PostMapping("/add")
    public Order addOrder(@RequestBody @Validated OrderDTO dto) {
        return service.addOrder(dto);
    }

    // GET ALL
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    // UPDATE
    @PutMapping("/update")
    public Order updateOrder(@RequestBody OrderDTO dto) {
        return service.updateOrder(dto);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }

    // ✅ NEW API (THIS FIXES YOUR 404)
    @GetMapping("/products")
    public Object getProductsFromProductService() {
        return service.getAllProductsFromProductService();
    }
}