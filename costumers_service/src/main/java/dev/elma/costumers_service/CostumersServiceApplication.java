package dev.elma.costumers_service;

import dev.elma.costumers_service.entities.Costumer;
import dev.elma.costumers_service.repositories.CostumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class CostumersServiceApplication implements CommandLineRunner {
    private CostumerRepository costumerRepository;
    public static void main(String[] args) {
        SpringApplication.run(CostumersServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List.of("Mohmmed","Ibrahim","Ahmed").forEach(
                costumer ->{
                    costumerRepository.save(
                            Costumer.builder()
                                    .firstName(costumer)
                                    .lastName("Elma")
                                    .email(costumer+"@gmail.com")
                                    .build()
                    );
                }
        );
    }
}
