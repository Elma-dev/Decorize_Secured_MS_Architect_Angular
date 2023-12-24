package dev.elma.account_service.web;

import dev.elma.account_service.entities.Account;
import dev.elma.account_service.feign.CostumerRestRequest;
import dev.elma.account_service.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
@EnableWebSecurity
public class AccountRestController {
    private AccountRepository accountRepository;
    private CostumerRestRequest costumerRestRequest;


    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        for (Account account:accounts) {
            Long customerId = account.getCustomerId();
            account.setCostumer(costumerRestRequest.getCostumerById(customerId));
        }
        return accounts;
    }
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

}
