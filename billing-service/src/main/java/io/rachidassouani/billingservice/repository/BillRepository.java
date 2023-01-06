package io.rachidassouani.billingservice.repository;

import io.rachidassouani.billingservice.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
