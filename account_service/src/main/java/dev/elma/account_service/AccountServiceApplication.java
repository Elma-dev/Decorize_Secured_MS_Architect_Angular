package dev.elma.account_service;

import dev.elma.account_service.entities.Account;
import dev.elma.account_service.enums.AccountType;
import dev.elma.account_service.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient// Enable service discovery
@AllArgsConstructor
@EnableFeignClients
public class AccountServiceApplication implements CommandLineRunner{
	private AccountRepository accountRepository;
	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List.of(1, 2, 3).forEach(
					account ->{
						accountRepository.save(
							Account.builder()
									.balance(1000.0)
									.customerId(account.longValue())
									.createdAt(new Date())
									.accountType(account % 2 == 0 ? AccountType.CURRENT : AccountType.SAVINGS)
									.build()
						);
					}
			);
		}

}