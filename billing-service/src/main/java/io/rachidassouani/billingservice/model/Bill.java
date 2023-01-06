package io.rachidassouani.billingservice.model;

import io.rachidassouani.billingservice.dto.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItemList;
    @Transient
    private Customer customer;
}
