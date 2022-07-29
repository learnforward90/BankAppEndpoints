package com.admin.swagger.model;


import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    Long id;

    String accountId;
    AccountType accountType;
    String clientId;
    Double balance=0.0;
    Boolean withdrawAllowed;

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountType=" + accountType +
                ", clientId='" + clientId + '\'' +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }
}
