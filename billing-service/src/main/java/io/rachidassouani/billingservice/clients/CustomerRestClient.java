package io.rachidassouani.billingservice.clients;


import io.rachidassouani.billingservice.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")
public interface CustomerRestClient {

    @GetMapping("customers/{id}")
    Customer findCustomerById(@PathVariable long id);
}
