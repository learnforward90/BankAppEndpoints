package com.admin.swagger.service;


import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {

    void deposit(String accountId, String clientId, Double amount);
}
