package com.ecommerce.customer.service;

import java.util.List;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.customer.dto.CustomerDTO;
import com.ecommerce.customer.entity.Customer;
import com.ecommerce.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    // CREATE
    public Customer addCustomer(CustomerDTO dto) {
        Customer c = new Customer();
        BeanUtils.copyProperties(dto, c);
        return repo.save(c);
    }

    // GET ALL
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    // UPDATE
    public Customer updateCustomer(CustomerDTO dto) {
        Customer c = new Customer();
        BeanUtils.copyProperties(dto, c);
        return repo.save(c);
    }

    // DELETE
    public String deleteCustomer(int id) {
        repo.deleteById(id);
        return "Customer deleted";
    }
    @Autowired
    private RestTemplate restTemplate;

    // ✅ ADD THIS METHOD
    public Object getAllProducts() {
        String url = "http://PRODUCT-SERVICE/product/all";
        return restTemplate.getForObject(url, Object.class);
    }
}