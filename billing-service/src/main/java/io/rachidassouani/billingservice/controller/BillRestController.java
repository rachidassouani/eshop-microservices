package io.rachidassouani.billingservice.controller;

import io.rachidassouani.billingservice.clients.CustomerRestClient;
import io.rachidassouani.billingservice.clients.ProductRestClient;
import io.rachidassouani.billingservice.dto.Customer;
import io.rachidassouani.billingservice.dto.Product;
import io.rachidassouani.billingservice.model.Bill;
import io.rachidassouani.billingservice.repository.BillRepository;
import io.rachidassouani.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final ProductRestClient productRestClient;
    private final CustomerRestClient customerRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, ProductRestClient productRestClient, CustomerRestClient customerRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.productRestClient = productRestClient;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("bills/{id}")
    public Bill findByById(@PathVariable long id) {

        Bill bill = billRepository.findById(id).get();
        if (bill == null) throw new RuntimeException("Bill not found!");

        Customer customer =customerRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);

        bill.getProductItemList().forEach(productItem -> {
            Product product = productRestClient.findProductById(productItem.getProductId());
            productItem.setProduct(product);
        });
        return bill;
    }
}