package com.admin.swagger.service;


import com.admin.swagger.model.Account;
import com.admin.swagger.model.AccountType;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AccountListingService {


    Account getClientAccountById(String clientID, String accountID);
    List<Account> getClientAccounts(String clientID);
//    Account getClientWithdrawAccount(String clientID, String accountID);

//    List<Account> getClientAccountsByType(String clientID, AccountType accountType);

}
