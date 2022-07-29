package com.admin.swagger.service;

import com.admin.swagger.dao.AccountDao;
import com.admin.swagger.model.Account;
import com.admin.swagger.model.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService{

    @Autowired
    private AccountDao accountDao;

    public AccountCreationServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void create(String accountId, String clientId, AccountType accountType){
        try {
            Account account = Account.builder()
                    .accountId(accountId).clientId(clientId)
                    .accountType(accountType)
                    .balance(0.0)
                    .withdrawAllowed(accountType.isWithdraw())
                    .build();
            accountDao.save(account);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
