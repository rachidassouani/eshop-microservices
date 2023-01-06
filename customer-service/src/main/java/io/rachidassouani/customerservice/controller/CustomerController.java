package io.rachidassouani.customerservice.controller;

import io.rachidassouani.customerservice.dao.CustomerRepository;
import io.rachidassouani.customerservice.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("customers")
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("customers/{id}")
    public Customer findCustomerById(@PathVariable long id) {
        return customerRepository.findById(id).get();
    }
}