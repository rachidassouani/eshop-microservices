package io.rachidassouani.customerservice;

import io.rachidassouani.customerservice.dao.CustomerRepository;
import io.rachidassouani.customerservice.model.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("Rachid").email("rachid@gmail.com").build(),
                            Customer.builder().name("Rachida").email("rachida@gmail.com").build(),
                            Customer.builder().name("Hanan").email("hanan@gmail.com").build()
                    )
            );
            customerRepository.findAll().forEach(customer -> System.out.println(customer));
        };
    }
}