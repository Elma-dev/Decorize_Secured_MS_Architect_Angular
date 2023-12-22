package dev.elma.account_service.repositories;

import dev.elma.account_service.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
