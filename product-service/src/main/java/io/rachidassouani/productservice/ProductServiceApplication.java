package io.rachidassouani.productservice;

import io.rachidassouani.productservice.dao.ProductRepository;
import io.rachidassouani.productservice.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.saveAll(
                    List.of(
                            Product.builder().name("laptop DELL").price(100).quantity(12).build(),
                            Product.builder().name("laptop HP").price(1000).quantity(54).build(),
                            Product.builder().name("laptop ASSUS").price(300).quantity(545).build()));
            productRepository.findAll().forEach(product -> System.out.println(product));
        };
    }
}