package io.rachidassouani.billingservice.repository;

import io.rachidassouani.billingservice.model.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
