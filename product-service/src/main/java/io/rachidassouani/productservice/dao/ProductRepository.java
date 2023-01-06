package io.rachidassouani.productservice.dao;

import io.rachidassouani.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
