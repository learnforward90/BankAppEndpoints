package com.admin.swagger.service;


import com.admin.swagger.dao.AccountDao;
import com.admin.swagger.dao.TransactionDao;
import com.admin.swagger.model.Account;
import com.admin.swagger.model.Transaction;
import com.admin.swagger.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AccountDepositServiceImpl implements AccountDepositService{

    @Autowired
    AccountDao accountDao;
    @Autowired
    TransactionDao transactionDao;

    @Override
    public void deposit(String accountId, String clientId, Double amount) {
        Account account;
        account = accountDao.findAccountByClientIdAndAccountId(clientId, accountId);
        System.out.println("GO GO ");
        System.out.println(amount);

        if (account != null){
           if (amount >= 0){
               account.setBalance(account.getBalance()+amount);
               accountDao.save(account);
               Transaction transaction = Transaction.builder()
                       .accountId(accountId)
                       .amount(amount)
                       .transactionType(TransactionType.DEPOSIT)
                       .date(LocalDate.now().toString())
                       .build();
               transactionDao.save(transaction);
           }
        }

    }
}
