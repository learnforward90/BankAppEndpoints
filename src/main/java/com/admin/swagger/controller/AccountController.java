package com.admin.swagger.controller;


import com.admin.swagger.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    public Bank bank;
    public String clientId = "1";

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts(){
        return bank.getAccounts(clientId);
    }

    @PostMapping
    public String createAccount(@RequestBody AccountDto accountDto){
        return bank.createNewAccount(accountDto);
    }

    @GetMapping("/{account_id}")
    public ResponseEntity<Object> getAccountById(@PathVariable("account_id") String accountId){
        return bank.getAccountById(accountId);
    }

    @DeleteMapping("/{account_id}")
    public String deleteAccount(@PathVariable("account_id") String accountId){
        return bank.deleteAccountById(accountId);
    }

    @PostMapping("/{account_id}/deposit")
    public String deposit(@PathVariable("account_id") String accountId, @RequestBody WithdrawDepositDto withdrawDepositDto){
        return bank.deposit(accountId, withdrawDepositDto);
    }

    @PostMapping("/{account_id}/withdraw")
    public String withdraw(@PathVariable("account_id") String accountId, @RequestBody WithdrawDepositDto withdrawDepositDto){
        return bank.withdraw(accountId, withdrawDepositDto);
    }

    @GetMapping("/{account_id}/transactions")
    public List<Transaction> getTransactions(@PathVariable("account_id") String accountId){
        return bank.getTransactions(accountId);
    }

}
