package dev.elma.account_service.entities;

import dev.elma.account_service.enums.AccountType;
import dev.elma.account_service.models.Costumer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @Builder
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private Double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long customerId;
    @Transient
    private Costumer costumer;




}
