package com.example.himom.service;

import com.example.himom.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccounts();

    Account getAccountByAccountId(String accountId);

    Boolean createNewAccount(Account newAccount);

    Boolean updateAccount(Account updatedAccount);

    Boolean deleteAccountById(String accountId);
}
