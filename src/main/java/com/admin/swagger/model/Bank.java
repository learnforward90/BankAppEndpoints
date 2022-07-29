package com.admin.swagger.model;


import com.admin.swagger.service.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bank {

    static Long clientId = 1L;
    static Long lastAccountNumber = 1L;

    @Autowired
    AccountListingServiceImpl accountListingService;
    @Autowired
    AccountCreationServiceImpl accountCreationService;
    @Autowired
    AccountDeleteServiceImpl accountDeleteService;
    @Autowired
    AccountDepositServiceImpl accountDepositService;
    @Autowired
    AccountWithdrawServiceImpl accountWithdrawService;

    @Autowired
    TransactionListingServiceImpl transactionListingService;

    void increaseLastAccountNumber(){
        lastAccountNumber += 1;
    }
    public String createNewAccount(AccountDto accountDto){

        String accountNumber = String.format("%03d%06d", clientId, lastAccountNumber);
        AccountType accountType1 = accountDto.getAccountType();
        accountCreationService.create(accountNumber, accountDto.getClientId().toString(), accountType1);
        increaseLastAccountNumber();
        return "Account with ID " + accountNumber + " was created";
    }

    public ResponseEntity<List<Account>> getAccounts(String clientId){
        ResponseEntity<List<Account>> accountResponse;
        List<Account> list = null;
        try {
            list = accountListingService.getClientAccounts(clientId);
            accountResponse = ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            accountResponse = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(list);
        }
        return accountResponse;

    }

    public ResponseEntity<Object> getAccountById(String accountID){
        ResponseEntity<Object> accountResponse;
        try{
            Account account = accountListingService.getClientAccountById(clientId.toString(), accountID);
            accountResponse = ResponseEntity.status(HttpStatus.OK).body(account);
        } catch (Exception e){
            accountResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
        }
        return accountResponse;
    }

    public String deleteAccountById(String accountId){
        accountDeleteService.delete(accountId);
        return "Successful delete";
    }

    public String deposit(String accountId, WithdrawDepositDto withdrawDepositDto){
        accountDepositService.deposit(accountId, clientId.toString(), withdrawDepositDto.getAmount());
        return "Successful deposit";
    }

    public String withdraw(String accountId, WithdrawDepositDto withdrawDepositDto) {
        return accountWithdrawService.withdraw(accountId, clientId.toString(), withdrawDepositDto.getAmount());
    }

    public List<Transaction> getTransactions(String accountId) {
        return transactionListingService.getTransactionsById(accountId);
    }
}
