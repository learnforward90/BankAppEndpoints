package com.admin.swagger.service;


import com.admin.swagger.dao.AccountDao;
import com.admin.swagger.dao.TransactionDao;
import com.admin.swagger.model.Account;
import com.admin.swagger.model.AccountType;
import com.admin.swagger.model.Transaction;
import com.admin.swagger.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {


    @Autowired
    AccountDao accountDao;

    @Autowired
    TransactionDao transactionDao;
    @Override
    public String withdraw(String accountId, String clientId, Double amount) {
        Account account;
        account = accountDao.findAccountByClientIdAndAccountId(clientId, accountId);

        String status = "";
        if (account != null){
            if (account.getAccountType() == AccountType.CHECKING ||
                    account.getAccountType() == AccountType.SAVING){
                if (amount >= 0 && account.getBalance() - amount >= 0){
                    account.setBalance(account.getBalance()-amount);
                    accountDao.save(account);
                    Transaction transaction = Transaction.builder()
                            .accountId(accountId)
                            .amount(amount)
                            .transactionType(TransactionType.WITHDRAW)
                            .date(LocalDate.now().toString())
                            .build();
                    transactionDao.save(transaction);
                    status = status + "Successful withdraw";
                }

            } else {
                status = status + "Cannot withdraw from such account : " + account.getAccountType();
            }
        }
        return status;
    }
}
