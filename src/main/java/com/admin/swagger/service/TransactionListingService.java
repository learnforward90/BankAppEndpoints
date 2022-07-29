package com.admin.swagger.service;


import com.admin.swagger.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionListingService {

    List<Transaction> getTransactionsById(String accountId);
}
