package com.admin.swagger.service;

import org.springframework.stereotype.Service;

@Service
public interface AccountDeleteService {

    void delete(String accountId);
}
