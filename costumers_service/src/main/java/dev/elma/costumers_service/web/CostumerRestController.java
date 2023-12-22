package dev.elma.costumers_service.web;



import dev.elma.costumers_service.entities.Costumer;
import dev.elma.costumers_service.repositories.CostumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/costumer")
@AllArgsConstructor
public class CostumerRestController {
    private CostumerRepository costumerRepository;
    @GetMapping("/all")
    public List<Costumer> getAllCostumers() {
        return costumerRepository.findAll();
    }
    @GetMapping("/{id}")
    public Costumer getCostumerById(@PathVariable Integer id) {
        return costumerRepository.findById(id).orElseThrow();
    }
}
