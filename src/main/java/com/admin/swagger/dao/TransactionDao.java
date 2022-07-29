package com.admin.swagger.dao;

import com.admin.swagger.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionDao extends CrudRepository<Transaction, Long> {


    List<Transaction> findTransactionsByAccountId(String accountId);

}
