package dev.elma.account_service.web;

import dev.elma.account_service.entities.Account;
import dev.elma.account_service.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountRestController {
    private AccountRepository accountRepository;

    public AccountRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

}
