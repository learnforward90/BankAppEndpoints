package com.admin.swagger.service;

import com.admin.swagger.model.AccountType;
import org.springframework.stereotype.Service;


@Service
public interface AccountCreationService {

    void create(String accountId, String clientId, AccountType accountType);
}
