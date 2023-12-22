package dev.elma.account_service.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString
public class Costumer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
