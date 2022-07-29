package com.admin.swagger.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountId;
    private double amount;
    private String date;
    private TransactionType transactionType;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", transactionType=" + transactionType +
                '}';
    }
}
