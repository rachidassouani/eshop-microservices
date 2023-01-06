package io.rachidassouani.billingservice;

import io.rachidassouani.billingservice.clients.CustomerRestClient;
import io.rachidassouani.billingservice.clients.ProductRestClient;
import io.rachidassouani.billingservice.dto.Customer;
import io.rachidassouani.billingservice.dto.Product;
import io.rachidassouani.billingservice.model.Bill;
import io.rachidassouani.billingservice.model.ProductItem;
import io.rachidassouani.billingservice.repository.BillRepository;
import io.rachidassouani.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {
        return args -> {

            Customer customer = customerRestClient.findCustomerById(1L);
            if (customer == null) throw new RuntimeException("Customer not found");

            Bill bill = Bill.builder()
                    .date(LocalDate.now())
                    .customerId(customer.getId())
                    .productItemList(null)
                    .build();
            Bill savedBill = billRepository.save(bill);

            List<Product> products = productRestClient.findAllProducts();
            products.forEach(product -> {
                ProductItem productItem= ProductItem.builder()
                        .bill(savedBill)
                        .productId(1L)
                        .discount(50)
                        .price(product.getPrice())
                        .quantity(20)
                        .build();
                productItemRepository.save(productItem);
            });
        };
    }
}