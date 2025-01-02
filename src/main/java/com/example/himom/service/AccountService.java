package com.example.himom.service;

import com.example.himom.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccounts();

    Account getAccountByAccountId(String accountId);

    Account getAccountByAccountEmail(String accountId);

    String autoCreateAccountId();

    Boolean createNewAccount(Account newAccount);

    Boolean updateAccount(Account updatedAccount);

    Boolean deleteAccountById(String accountId);

    Boolean checkRightEmailToRetakeAccount(String accountEmail);
}
