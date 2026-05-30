package com.ecommerce.order.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.order.dto.OrderDTO;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private RestTemplate restTemplate;   // ✅ NEW

    // CREATE
    public Order addOrder(OrderDTO dto) {
        Order o = new Order();
        BeanUtils.copyProperties(dto, o);
        return repo.save(o);
    }

    // GET ALL
    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    // UPDATE
    public Order updateOrder(OrderDTO dto) {
        Order o = new Order();
        BeanUtils.copyProperties(dto, o);
        return repo.save(o);
    }

    // DELETE
    public String deleteOrder(int id) {
        repo.deleteById(id);
        return "Order deleted";
    }

    // ✅ NEW METHOD (VERY IMPORTANT)
    public Object getAllProductsFromProductService() {
    	String url = "http://PRODUCT-SERVICE/product/all";
        return restTemplate.getForObject(url, Object.class);
    }
}