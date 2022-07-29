package com.admin.swagger.service;


import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {


    String withdraw(String accountId, String clientId, Double amount);
}
