package com.admin.swagger.service;


import com.admin.swagger.dao.TransactionDao;
import com.admin.swagger.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionListingServiceImpl implements TransactionListingService {

    @Autowired
    TransactionDao transactionDao;
    @Override
    public List<Transaction> getTransactionsById(String accountId) {
        List<Transaction> transactions = new ArrayList<>();
        transactions = transactionDao.findTransactionsByAccountId(accountId);
        return transactions;
    }
}
