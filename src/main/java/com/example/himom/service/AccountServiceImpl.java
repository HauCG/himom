package com.example.himom.service;

import com.example.himom.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    // Simulating a database with a list
    private final List<Account> accounts = new ArrayList<>();

    public AccountServiceImpl() {
        // Adding 3 sample accounts
        accounts.add(new Account("1", "JohnDoe", "john.doe@example.com"));
        accounts.add(new Account("2", "JaneDoe", "jane.doe@example.com"));
        accounts.add(new Account("3", "SamSmith", "sam.smith@example.com"));
    }

    @Override
    public List<Account> findAllAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public Account getAccountByAccountId(String accountId) {
        Optional<Account> account = accounts.stream()
                .filter(a -> a.getAccountId().equals(accountId))
                .findFirst();
        return account.orElse(null);
    }

    @Override
    public Boolean createNewAccount(Account newAccount) {
        if (newAccount == null || accounts.stream().anyMatch(a -> a.getAccountId().equals(newAccount.getAccountId()))) {
            return false;
        }
        accounts.add(newAccount);
        return true;
    }

    @Override
    public Boolean updateAccount(Account updatedAccount) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountId().equals(updatedAccount.getAccountId())) {
                accounts.set(i, updatedAccount);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean deleteAccountById(String accountId) {
        return accounts.removeIf(account -> account.getAccountId().equals(accountId));
    }
}
