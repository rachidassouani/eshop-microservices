package io.rachidassouani.productservice.controller;

import io.rachidassouani.productservice.dao.ProductRepository;
import io.rachidassouani.productservice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("products")
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("products/{id}")
    public Product findProductById(@PathVariable long id) {
        return productRepository.findById(id).get();
    }
}