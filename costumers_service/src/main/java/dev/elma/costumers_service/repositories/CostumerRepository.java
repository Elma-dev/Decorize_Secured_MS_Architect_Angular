package dev.elma.costumers_service.repositories;


import dev.elma.costumers_service.entities.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer, Integer> {

}
