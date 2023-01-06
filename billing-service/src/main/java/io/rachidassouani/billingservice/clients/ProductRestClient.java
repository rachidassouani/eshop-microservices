package io.rachidassouani.billingservice.clients;

import io.rachidassouani.billingservice.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="product-service")
public interface ProductRestClient {

    @GetMapping("products/{id}")
    Product findProductById(@PathVariable long id);

    @GetMapping("products")
    List<Product> findAllProducts();
}
