package com.example.himom.service;

import com.example.himom.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class AccountServiceImpl implements AccountService {
    // Simulating a database with a list
    private final List<Account> accounts = new ArrayList<>();

    public AccountServiceImpl() {
        // Adding 3 sample accounts
        accounts.add(new Account("kxh8nisxf9aun2v30yi9w7fpiozk08", "hau", "hau123", "hau@example.com"));
        accounts.add(new Account("mmtwurtxj6fgn18t573o0ybctahp2g", "kien", "kien123", "kien@example.com"));
        accounts.add(new Account("aw44dsq5e8ava8mak9zj76eauebp4u", "tung", "tung123", "tung@example.com"));
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
    public Account getAccountByAccountEmail(String accountEmail) {
        System.out.println("Searching for account with email: " + accountEmail);
        accounts.forEach(acc -> System.out.println("Account in DB: " + acc.getAccountEmail()));
        
        Optional<Account> account = accounts.stream()
                .filter(a -> a.getAccountEmail().equals(accountEmail))
                .findFirst();
        System.out.println("Found account: " + account.orElse(null));
        return account.orElse(null);
    }

    @Override
    public String autoCreateAccountId() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder accountIdRandom = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            int randomIndex = random.nextInt(alphabet.length());
            accountIdRandom.append(alphabet.charAt(randomIndex));
        }
        return accountIdRandom.toString();
    }


    @Override
    public Boolean createNewAccount(Account newAccount) {
        String newAccountId = autoCreateAccountId();

        boolean isAccountIdDuplicate;
        do {
            String finalNewAccountId = newAccountId;
            isAccountIdDuplicate = accounts.stream().anyMatch(account -> account.getAccountId().equals(finalNewAccountId));

            if (isAccountIdDuplicate) {
                newAccountId = autoCreateAccountId();
            }
        } while (isAccountIdDuplicate);


        newAccount.setAccountId(newAccountId);
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

    @Override
    public Boolean checkRightEmailToRetakeAccount(String accountEmail) {
        for (Account account : accounts) {
            if (account.getAccountEmail().equals(accountEmail)) {
                return true;
            }
        }
        return false;
    }
}