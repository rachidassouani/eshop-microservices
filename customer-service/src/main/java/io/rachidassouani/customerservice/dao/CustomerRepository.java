package io.rachidassouani.customerservice.dao;

import io.rachidassouani.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
