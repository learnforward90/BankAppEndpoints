package com.admin.swagger.service;

import com.admin.swagger.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDeleteServiceImpl implements AccountDeleteService{

    @Autowired
    AccountDao accountDao;


    @Override
    public void delete(String accountId) {
        accountDao.delete(accountDao.findAccountByClientIdAndAccountId("1", accountId));
    }
}
