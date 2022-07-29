package com.admin.swagger.dao;

import com.admin.swagger.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao extends CrudRepository<Account, String> {

    List<Account> findAccountsByClientId(String clientId);
    Account findAccountByClientIdAndAccountId(String clientId, String accountId);

}
