package com.admin.swagger.service;

import com.admin.swagger.dao.AccountDao;
import com.admin.swagger.model.Account;
import com.admin.swagger.model.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService{

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account getClientAccountById(String clientID, String accountID) {
        return accountDao.findAccountByClientIdAndAccountId(clientID, accountID);
    }

    @Override
    public List<Account> getClientAccounts(String clientID) {
        return accountDao.findAccountsByClientId(clientID);
    }

}
