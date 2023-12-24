package dev.elma.account_service.feign;
import dev.elma.account_service.models.Costumer;
import dev.elma.account_service.security.FeignInterceptor;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "costumer-service",configuration = FeignInterceptor.class)
public interface CostumerRestRequest {
    @GetMapping("costumer/all")
    public List<Costumer> allCostumers();
    @GetMapping("costumer/{id}")
    public Costumer getCostumerById(@PathVariable Long id);
}
