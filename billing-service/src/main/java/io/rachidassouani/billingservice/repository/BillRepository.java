package io.rachidassouani.billingservice.repository;

import io.rachidassouani.billingservice.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findAllBillsByCustomerId(long customerId);
}
